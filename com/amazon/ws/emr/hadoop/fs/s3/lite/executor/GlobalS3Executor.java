package com.amazon.ws.emr.hadoop.fs.s3.lite.executor;

import com.amazon.ws.emr.hadoop.fs.property.RetryPolicyType;
import com.amazon.ws.emr.hadoop.fs.s3.lite.ConnectionErrors;
import com.amazon.ws.emr.hadoop.fs.s3.lite.S3Errors;
import com.amazon.ws.emr.hadoop.fs.s3.lite.bucket.BucketRegionStore;
import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Call;
import com.amazon.ws.emr.hadoop.fs.s3.lite.provider.S3Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.HeadBucketRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.HeadBucketResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GlobalS3Executor<C extends AmazonS3>
  implements S3Executor<C>
{
  private static final Logger logger = LoggerFactory.getLogger(GlobalS3Executor.class);
  private static final long RETRY_INTERVAL_MS = 1000L;
  @VisibleForTesting
  static final int MAX_REDIRECTS_ALLOWED = 10;
  @VisibleForTesting
  static final int MAX_HTTP_200_ERROR_RETRIES_ALLOWED = 3;
  private final int maxInterruptedIOExceptionExecutorLevelRetriesAllowed;
  private final S3Provider<C> s3Provider;
  private final String defaultEndpoint;
  private final BucketRegionStore bucketRegionStore;
  private final List<S3CallOverrider> overriders;
  
  public GlobalS3Executor(S3Provider<C> s3Provider, String defaultEndpoint, BucketRegionStore bucketRegionStore, List<S3CallOverrider> overriders)
  {
    this.s3Provider = s3Provider;
    this.defaultEndpoint = defaultEndpoint;
    this.bucketRegionStore = bucketRegionStore;
    this.overriders = overriders;
    
    maxInterruptedIOExceptionExecutorLevelRetriesAllowed = (s3Provider.isInitialTimeoutSet() ? 1 : 0);
  }
  
  public <R> R execute(S3Call<R, ? super C> call)
  {
    return (R)execute(call, false);
  }
  
  public <R> R execute(S3Call<R, ? super C> call, boolean shouldTryInitialTimeout)
  {
    int redirectRetries = 0;
    int errorCodeRetries = 0;
    int socketTimeoutRetries = 0;
    String bucketName = call.getBucketName();
    Preconditions.checkNotNull(bucketName, "BucketName is required");
    call = executeOverriders(call);
    for (;;)
    {
      C client = getClient(bucketName, (shouldTryInitialTimeout) && (socketTimeoutRetries < maxInterruptedIOExceptionExecutorLevelRetriesAllowed));
      try
      {
        return (R)call.perform(client);
      }
      catch (AmazonS3Exception e)
      {
        if (handlePermanentRedirect(e, client, bucketName))
        {
          redirectRetries++;
          if (redirectRetries <= 10) {
            continue;
          }
          logger.warn("Exceeded maximum number of {} for allowed redirects", Integer.valueOf(10));
        }
        if (S3Errors.isHttp200WithErrorCode(e))
        {
          errorCodeRetries++;
          if (errorCodeRetries <= 3)
          {
            long backOffInterval = EmrFsUtils.calculateRetryInterval(RetryPolicyType.EXPONENTIAL, 1000L, errorCodeRetries);
            
            logger.debug("Retrying s3 call '{}' with resource '{}' in {} milliseconds for a S3 200 OK response with error code '{}', and error message: {}", new Object[] {call
            
              .getClass().getSimpleName(), call
              .getS3Resources(), 
              Long.valueOf(backOffInterval), e
              .getErrorCode(), e
              .getErrorMessage() });
            waitForRetry(backOffInterval);
            continue;
          }
          logger.warn("Exceeded maximum number of {} for allowed 200 OK with Errors", 
            Integer.valueOf(3));
        }
        throw e;
      }
      catch (Exception e)
      {
        if ((shouldTryInitialTimeout) && (s3Provider.isInitialTimeoutSet())) {
          if (ConnectionErrors.isCausedByInterruptedIOException(e))
          {
            socketTimeoutRetries++;
            if (socketTimeoutRetries <= maxInterruptedIOExceptionExecutorLevelRetriesAllowed)
            {
              logger.debug("Use default timeout configuration to retry for read timeout");
              continue;
            }
            logger.warn("Exceeded maximum number of retries ({}) allowed for socket timeout", 
              Integer.valueOf(maxInterruptedIOExceptionExecutorLevelRetriesAllowed));
          }
        }
        throw e;
      }
    }
  }
  
  @VisibleForTesting
  void waitForRetry(long backOffInterval)
  {
    EmrFsUtils.sleep(backOffInterval);
  }
  
  private <R> S3Call<R, ? super C> executeOverriders(S3Call<R, ? super C> call)
  {
    for (S3CallOverrider overrider : overriders) {
      call = overrider.override(call);
    }
    return call;
  }
  
  private C getClient(String bucketName, boolean tryInitialTimeout)
  {
    String endpoint = getEndpoint(bucketName);
    if (tryInitialTimeout) {
      return s3Provider.getS3WithInitialTimeoutOrS3Default(endpoint);
    }
    return s3Provider.getS3(endpoint);
  }
  
  private String getEndpoint(String bucketName)
  {
    Region bucketRegion = bucketRegionStore.get(bucketName);
    if (bucketRegion == null) {
      return defaultEndpoint;
    }
    return EmrFsUtils.getS3Endpoint(bucketRegion);
  }
  
  private boolean handlePermanentRedirect(AmazonS3Exception e, C client, String bucketName)
  {
    if (!S3Errors.isPermanentRedirect(e)) {
      return false;
    }
    String regionString = getBucketRegion(e, client, bucketName);
    if (regionString == null)
    {
      logger.warn("Could not determine region to redirect to for bucket {}", bucketName);
      return false;
    }
    logger.info("Bucket {} is in the {} region. Please configure the proper region to avoid multiple unnecessary redirects", bucketName, regionString);
    
    Region region = RegionUtils.getRegion(regionString);
    if (region == null)
    {
      logger.warn("Region information for {} is not available. Cannot handle permanent redirect for bucket {}", regionString, bucketName);
      
      return false;
    }
    bucketRegionStore.put(bucketName, region);
    return true;
  }
  
  private static String getBucketRegion(AmazonS3Exception e, AmazonS3 s3, String bucketName)
  {
    String bucketRegion = S3Errors.getBucketRegion(e);
    if (bucketRegion != null) {
      return bucketRegion;
    }
    logger.info("Could not get region for bucket {} from exception. Trying a head request", bucketName);
    
    return getBucketRegionViaHeadRequest(s3, bucketName);
  }
  
  private static String getBucketRegionViaHeadRequest(AmazonS3 s3, String bucketName)
  {
    try
    {
      HeadBucketResult result = s3.headBucket(new HeadBucketRequest(bucketName));
      return result.getBucketRegion();
    }
    catch (AmazonS3Exception e)
    {
      return S3Errors.getBucketRegion(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.executor.GlobalS3Executor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */
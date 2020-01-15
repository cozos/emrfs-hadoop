package com.amazon.ws.emr.hadoop.fs.s3.lite.handler;

import com.amazon.ws.emr.hadoop.fs.s3.lite.S3Errors;
import com.amazon.ws.emr.hadoop.fs.s3.lite.bucket.BucketRegionStore;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.HeadBucketRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HeadBucketRedirectHandler
  extends RequestHandler2
{
  private static final Logger logger = LoggerFactory.getLogger(HeadBucketRedirectHandler.class);
  private final BucketRegionStore bucketRegionStore;
  
  public HeadBucketRedirectHandler(BucketRegionStore bucketRegionStore)
  {
    this.bucketRegionStore = bucketRegionStore;
  }
  
  public void afterError(Request<?> request, Response<?> response, Exception e)
  {
    if ((e instanceof AmazonS3Exception)) {
      afterS3Error(request, (AmazonS3Exception)e);
    }
  }
  
  private void afterS3Error(Request<?> request, AmazonS3Exception e)
  {
    if (!S3Errors.isPermanentRedirect(e)) {
      return;
    }
    AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
    if ((originalRequest instanceof HeadBucketRequest))
    {
      String bucketName = ((HeadBucketRequest)originalRequest).getBucketName();
      afterPermanentRedirect(bucketName, e);
    }
  }
  
  private void afterPermanentRedirect(String bucketName, AmazonS3Exception e)
  {
    String regionString = S3Errors.getBucketRegion(e);
    if (regionString == null) {
      return;
    }
    Region region = RegionUtils.getRegion(regionString);
    if (region == null)
    {
      logger.warn("Region information for {} is not available. Cannot store the bucket region for bucket {}", regionString, bucketName);
      
      return;
    }
    logger.debug("Storing bucket region for bucket {} and region {}", bucketName, region);
    bucketRegionStore.put(bucketName, region);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.handler.HeadBucketRedirectHandler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */
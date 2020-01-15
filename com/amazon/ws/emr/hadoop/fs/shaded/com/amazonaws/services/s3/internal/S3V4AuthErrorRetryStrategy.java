package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Regions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.AuthErrorRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.AuthRetryParameters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Immutable
public class S3V4AuthErrorRetryStrategy
  implements AuthErrorRetryStrategy
{
  private static Log log = LogFactory.getLog(S3V4AuthErrorRetryStrategy.class);
  private static final String V4_REGION_WARNING = "please use region-specific endpoint to access buckets located in regions that require V4 signing.";
  private final S3RequestEndpointResolver endpointResolver;
  private final SdkPredicate<AmazonServiceException> sigV4RetryPredicate;
  
  public S3V4AuthErrorRetryStrategy(S3RequestEndpointResolver endpointResolver)
  {
    this(endpointResolver, new IsSigV4RetryablePredicate());
  }
  
  S3V4AuthErrorRetryStrategy(S3RequestEndpointResolver endpointResolver, SdkPredicate<AmazonServiceException> isSigV4Retryable)
  {
    this.endpointResolver = endpointResolver;
    sigV4RetryPredicate = isSigV4Retryable;
  }
  
  public AuthRetryParameters shouldRetryWithAuthParam(Request<?> request, HttpResponse response, AmazonServiceException ase)
  {
    if (!sigV4RetryPredicate.test(ase)) {
      return null;
    }
    if (hasServingRegionHeader(response)) {
      return redirectToRegionInHeader(request, response);
    }
    if (canUseVirtualAddressing()) {
      return redirectToS3External();
    }
    throw new SdkClientException("please use region-specific endpoint to access buckets located in regions that require V4 signing.", ase);
  }
  
  private boolean canUseVirtualAddressing()
  {
    return BucketNameUtils.isDNSBucketName(endpointResolver.getBucketName());
  }
  
  private AuthRetryParameters redirectToRegionInHeader(Request<?> request, HttpResponse response)
  {
    String region = getServingRegionHeader(response);
    AWSS3V4Signer v4Signer = buildSigV4Signer(region);
    endpointResolver.resolveRequestEndpoint(request, region);
    return buildRetryParams(v4Signer, request.getEndpoint());
  }
  
  private AuthRetryParameters redirectToS3External()
  {
    AWSS3V4Signer v4Signer = buildSigV4Signer(Regions.US_EAST_1.getName());
    try
    {
      URI bucketEndpoint = new URI(String.format("https://%s.s3-external-1.amazonaws.com", new Object[] { endpointResolver.getBucketName() }));
      return buildRetryParams(v4Signer, bucketEndpoint);
    }
    catch (URISyntaxException e)
    {
      throw new SdkClientException("Failed to re-send the request to \"s3-external-1.amazonaws.com\". please use region-specific endpoint to access buckets located in regions that require V4 signing.", e);
    }
  }
  
  private AWSS3V4Signer buildSigV4Signer(String region)
  {
    AWSS3V4Signer v4Signer = new AWSS3V4Signer();
    v4Signer.setRegionName(region);
    v4Signer.setServiceName("s3");
    return v4Signer;
  }
  
  private AuthRetryParameters buildRetryParams(AWSS3V4Signer signer, URI endpoint)
  {
    log.warn("Attempting to re-send the request to " + endpoint.getHost() + " with AWS V4 authentication. To avoid this warning in the future, " + "please use region-specific endpoint to access buckets located in regions that require V4 signing.");
    
    return new AuthRetryParameters(signer, endpoint);
  }
  
  private static boolean hasServingRegionHeader(HttpResponse response)
  {
    return !StringUtils.isNullOrEmpty(getServingRegionHeader(response));
  }
  
  private static String getServingRegionHeader(HttpResponse response)
  {
    return (String)response.getHeaders().get("x-amz-region");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3V4AuthErrorRetryStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.s3.lite;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AwsHostNameUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

public final class S3Errors
{
  private static final String ENDPOINT_KEY = "Endpoint";
  
  private S3Errors()
  {
    throw new AssertionError();
  }
  
  public static boolean isPermanentRedirect(AmazonS3Exception exception)
  {
    checkExceptionNotNull(exception);
    return exception.getStatusCode() == 301;
  }
  
  public static boolean isHttp200WithErrorCode(AmazonS3Exception exception)
  {
    checkExceptionNotNull(exception);
    return (exception.getStatusCode() == 200) && 
      (StringUtils.isNotEmpty(((String)Optional.ofNullable(exception.getErrorCode()).orElse("")).trim()));
  }
  
  @Nullable
  public static String getBucketRegion(AmazonS3Exception exception)
  {
    checkExceptionNotNull(exception);
    Map<String, String> additionalDetails = exception.getAdditionalDetails();
    if (additionalDetails != null)
    {
      String bucketRegion = (String)additionalDetails.get("x-amz-bucket-region");
      if (bucketRegion != null) {
        return bucketRegion;
      }
      String endpoint = (String)additionalDetails.get("Endpoint");
      if (endpoint != null) {
        return parseRegionName(endpoint);
      }
    }
    return null;
  }
  
  private static void checkExceptionNotNull(AmazonS3Exception exception)
  {
    Preconditions.checkNotNull(exception, "AmazonS3Exception is required");
  }
  
  private static String parseRegionName(String endpoint)
  {
    return AwsHostNameUtils.parseRegionName(endpoint, "s3");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.S3Errors
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */
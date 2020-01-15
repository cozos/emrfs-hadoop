package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;

public class CompleteMultipartUploadRetryablePredicate
  extends SdkPredicate<AmazonS3Exception>
{
  private static final String ERROR_CODE = "InternalError";
  private static final String RETYABLE_ERROR_MESSAGE = "Please try again.";
  
  public boolean test(AmazonS3Exception exception)
  {
    if ((exception == null) || (exception.getErrorCode() == null) || 
      (exception.getErrorMessage() == null)) {
      return false;
    }
    return (exception.getErrorCode().contains("InternalError")) && 
      (exception.getErrorMessage().contains("Please try again."));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.CompleteMultipartUploadRetryablePredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicy.RetryCondition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

public class CompleteMultipartUploadRetryCondition
  implements RetryPolicy.RetryCondition
{
  private static final int MAX_RETRY_ATTEMPTS = 3;
  private final SdkPredicate<AmazonS3Exception> completeMultipartRetryablePredicate;
  private final int maxCompleteMultipartUploadRetries;
  
  public CompleteMultipartUploadRetryCondition()
  {
    this(new CompleteMultipartUploadRetryablePredicate(), 3);
  }
  
  @SdkTestInternalApi
  CompleteMultipartUploadRetryCondition(SdkPredicate<AmazonS3Exception> predicate, int maxRetryAttempts)
  {
    ValidationUtils.assertNotNull(predicate, "sdk predicate");
    completeMultipartRetryablePredicate = predicate;
    maxCompleteMultipartUploadRetries = maxRetryAttempts;
  }
  
  public boolean shouldRetry(AmazonWebServiceRequest originalRequest, AmazonClientException exception, int retriesAttempted)
  {
    if ((exception instanceof AmazonS3Exception)) {
      return (completeMultipartRetryablePredicate.test((AmazonS3Exception)exception)) && (retriesAttempted < maxCompleteMultipartUploadRetries);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.CompleteMultipartUploadRetryCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
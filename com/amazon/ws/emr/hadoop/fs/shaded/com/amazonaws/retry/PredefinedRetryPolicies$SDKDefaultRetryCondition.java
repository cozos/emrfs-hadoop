package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.IOException;

public class PredefinedRetryPolicies$SDKDefaultRetryCondition
  implements RetryPolicy.RetryCondition
{
  public boolean shouldRetry(AmazonWebServiceRequest originalRequest, AmazonClientException exception, int retriesAttempted)
  {
    if ((exception.getCause() instanceof IOException)) {
      return true;
    }
    if ((exception instanceof AmazonServiceException))
    {
      AmazonServiceException ase = (AmazonServiceException)exception;
      if (RetryUtils.isRetryableServiceException(ase)) {
        return true;
      }
      if (RetryUtils.isThrottlingException(ase)) {
        return true;
      }
      if (RetryUtils.isClockSkewError(ase)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedRetryPolicies.SDKDefaultRetryCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
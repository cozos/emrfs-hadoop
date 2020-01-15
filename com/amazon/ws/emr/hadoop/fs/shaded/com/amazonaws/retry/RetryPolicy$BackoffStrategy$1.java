package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;

final class RetryPolicy$BackoffStrategy$1
  implements RetryPolicy.BackoffStrategy
{
  public long delayBeforeNextRetry(AmazonWebServiceRequest originalRequest, AmazonClientException exception, int retriesAttempted)
  {
    return 0L;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicy.BackoffStrategy.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
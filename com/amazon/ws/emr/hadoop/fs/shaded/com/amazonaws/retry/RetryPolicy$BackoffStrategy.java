package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;

public abstract interface RetryPolicy$BackoffStrategy
{
  public static final BackoffStrategy NO_DELAY = new BackoffStrategy()
  {
    public long delayBeforeNextRetry(AmazonWebServiceRequest originalRequest, AmazonClientException exception, int retriesAttempted)
    {
      return 0L;
    }
  };
  
  public abstract long delayBeforeNextRetry(AmazonWebServiceRequest paramAmazonWebServiceRequest, AmazonClientException paramAmazonClientException, int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicy.BackoffStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
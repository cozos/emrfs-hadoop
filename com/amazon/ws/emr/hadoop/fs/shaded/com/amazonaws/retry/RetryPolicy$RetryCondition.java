package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;

public abstract interface RetryPolicy$RetryCondition
{
  public static final RetryCondition NO_RETRY_CONDITION = new RetryCondition()
  {
    public boolean shouldRetry(AmazonWebServiceRequest originalRequest, AmazonClientException exception, int retriesAttempted)
    {
      return false;
    }
  };
  
  public abstract boolean shouldRetry(AmazonWebServiceRequest paramAmazonWebServiceRequest, AmazonClientException paramAmazonClientException, int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicy.RetryCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
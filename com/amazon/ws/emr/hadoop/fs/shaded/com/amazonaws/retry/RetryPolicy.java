package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;

@Immutable
public final class RetryPolicy
{
  private final RetryCondition retryCondition;
  private final BackoffStrategy backoffStrategy;
  private final int maxErrorRetry;
  private final boolean honorMaxErrorRetryInClientConfig;
  
  public RetryPolicy(RetryCondition retryCondition, BackoffStrategy backoffStrategy, int maxErrorRetry, boolean honorMaxErrorRetryInClientConfig)
  {
    if (retryCondition == null) {
      retryCondition = PredefinedRetryPolicies.DEFAULT_RETRY_CONDITION;
    }
    if (backoffStrategy == null) {
      backoffStrategy = PredefinedRetryPolicies.DEFAULT_BACKOFF_STRATEGY;
    }
    if (maxErrorRetry < 0) {
      throw new IllegalArgumentException("Please provide a non-negative value for maxErrorRetry.");
    }
    this.retryCondition = retryCondition;
    this.backoffStrategy = backoffStrategy;
    this.maxErrorRetry = maxErrorRetry;
    this.honorMaxErrorRetryInClientConfig = honorMaxErrorRetryInClientConfig;
  }
  
  public RetryCondition getRetryCondition()
  {
    return retryCondition;
  }
  
  public BackoffStrategy getBackoffStrategy()
  {
    return backoffStrategy;
  }
  
  public int getMaxErrorRetry()
  {
    return maxErrorRetry;
  }
  
  public boolean isMaxErrorRetryInClientConfigHonored()
  {
    return honorMaxErrorRetryInClientConfig;
  }
  
  public static abstract interface RetryCondition
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
  
  public static abstract interface BackoffStrategy
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
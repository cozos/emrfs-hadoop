package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

public class SimpleRetryPolicy
  implements RetryPolicy
{
  private final RetryCondition retryCondition;
  private final BackoffStrategy backoffStrategy;
  
  public SimpleRetryPolicy(RetryCondition retryCondition, BackoffStrategy backoffStrategy)
  {
    this.retryCondition = ((RetryCondition)ValidationUtils.assertNotNull(retryCondition, "retryCondition"));
    this.backoffStrategy = ((BackoffStrategy)ValidationUtils.assertNotNull(backoffStrategy, "backoffStrategy"));
  }
  
  public long computeDelayBeforeNextRetry(RetryPolicyContext context)
  {
    return backoffStrategy.computeDelayBeforeNextRetry(context);
  }
  
  public boolean shouldRetry(RetryPolicyContext context)
  {
    return retryCondition.shouldRetry(context);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.SimpleRetryPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
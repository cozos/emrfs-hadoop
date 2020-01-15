package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2;

public abstract interface BackoffStrategy
{
  public abstract long computeDelayBeforeNextRetry(RetryPolicyContext paramRetryPolicyContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.BackoffStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
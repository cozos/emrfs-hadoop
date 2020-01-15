package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2;

public abstract interface RetryCondition
{
  public abstract boolean shouldRetry(RetryPolicyContext paramRetryPolicyContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
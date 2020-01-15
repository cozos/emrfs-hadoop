package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

public class MaxNumberOfRetriesCondition
  implements RetryCondition
{
  private final int maxNumberOfRetries;
  
  public MaxNumberOfRetriesCondition(int maxNumberOfRetries)
  {
    this.maxNumberOfRetries = ValidationUtils.assertIsPositive(maxNumberOfRetries, "maxNumberOfRetries");
  }
  
  public boolean shouldRetry(RetryPolicyContext context)
  {
    return context.retriesAttempted() < maxNumberOfRetries;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.MaxNumberOfRetriesCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
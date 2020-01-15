package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

public class FixedDelayBackoffStrategy
  implements BackoffStrategy
{
  private final int fixedBackoff;
  
  public FixedDelayBackoffStrategy(int fixedBackoff)
  {
    this.fixedBackoff = ValidationUtils.assertIsPositive(fixedBackoff, "fixedBackoff");
  }
  
  public long computeDelayBeforeNextRetry(RetryPolicyContext context)
  {
    return fixedBackoff;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.FixedDelayBackoffStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
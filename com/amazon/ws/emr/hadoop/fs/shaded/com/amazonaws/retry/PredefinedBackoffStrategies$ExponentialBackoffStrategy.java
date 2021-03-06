package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicyContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

public class PredefinedBackoffStrategies$ExponentialBackoffStrategy
  extends V2CompatibleBackoffStrategyAdapter
{
  private final int baseDelay;
  private final int maxBackoffTime;
  
  public PredefinedBackoffStrategies$ExponentialBackoffStrategy(int baseDelay, int maxBackoffTime)
  {
    this.baseDelay = ValidationUtils.assertIsPositive(baseDelay, "Base delay");
    this.maxBackoffTime = ValidationUtils.assertIsPositive(maxBackoffTime, "Max backoff");
  }
  
  public long computeDelayBeforeNextRetry(RetryPolicyContext context)
  {
    return PredefinedBackoffStrategies.access$000(context.retriesAttempted(), baseDelay, maxBackoffTime);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedBackoffStrategies.ExponentialBackoffStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
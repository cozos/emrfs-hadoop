package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicyContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.Random;

public class PredefinedBackoffStrategies$FullJitterBackoffStrategy
  extends V2CompatibleBackoffStrategyAdapter
{
  private final int baseDelay;
  private final int maxBackoffTime;
  private final Random random = new Random();
  
  public PredefinedBackoffStrategies$FullJitterBackoffStrategy(int baseDelay, int maxBackoffTime)
  {
    this.baseDelay = ValidationUtils.assertIsPositive(baseDelay, "Base delay");
    this.maxBackoffTime = ValidationUtils.assertIsPositive(maxBackoffTime, "Max backoff");
  }
  
  public long computeDelayBeforeNextRetry(RetryPolicyContext context)
  {
    int ceil = PredefinedBackoffStrategies.access$000(context.retriesAttempted(), baseDelay, maxBackoffTime);
    return random.nextInt(ceil);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedBackoffStrategies.FullJitterBackoffStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
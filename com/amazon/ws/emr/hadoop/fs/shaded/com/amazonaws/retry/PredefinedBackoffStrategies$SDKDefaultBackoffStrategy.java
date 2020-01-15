package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.BackoffStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicyContext;

public class PredefinedBackoffStrategies$SDKDefaultBackoffStrategy
  extends V2CompatibleBackoffStrategyAdapter
{
  private final BackoffStrategy fullJitterBackoffStrategy;
  private final BackoffStrategy equalJitterBackoffStrategy;
  
  public PredefinedBackoffStrategies$SDKDefaultBackoffStrategy()
  {
    fullJitterBackoffStrategy = new PredefinedBackoffStrategies.FullJitterBackoffStrategy(100, 20000);
    
    equalJitterBackoffStrategy = new PredefinedBackoffStrategies.EqualJitterBackoffStrategy(500, 20000);
  }
  
  public PredefinedBackoffStrategies$SDKDefaultBackoffStrategy(int baseDelay, int throttledBaseDelay, int maxBackoff)
  {
    fullJitterBackoffStrategy = new PredefinedBackoffStrategies.FullJitterBackoffStrategy(baseDelay, maxBackoff);
    
    equalJitterBackoffStrategy = new PredefinedBackoffStrategies.EqualJitterBackoffStrategy(throttledBaseDelay, maxBackoff);
  }
  
  public long computeDelayBeforeNextRetry(RetryPolicyContext context)
  {
    if (RetryUtils.isThrottlingException(context.exception())) {
      return equalJitterBackoffStrategy.computeDelayBeforeNextRetry(context);
    }
    return fullJitterBackoffStrategy.computeDelayBeforeNextRetry(context);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedBackoffStrategies.SDKDefaultBackoffStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
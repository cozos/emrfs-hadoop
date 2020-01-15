package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.BackoffStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicyContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.Random;

public class PredefinedBackoffStrategies
{
  private static final int SDK_DEFAULT_BASE_DELAY = 100;
  static final int SDK_DEFAULT_THROTTLED_BASE_DELAY = 500;
  static final int SDK_DEFAULT_MAX_BACKOFF_IN_MILLISECONDS = 20000;
  static final int DYNAMODB_DEFAULT_BASE_DELAY = 25;
  private static final int MAX_RETRIES = 30;
  
  public static class FullJitterBackoffStrategy
    extends V2CompatibleBackoffStrategyAdapter
  {
    private final int baseDelay;
    private final int maxBackoffTime;
    private final Random random = new Random();
    
    public FullJitterBackoffStrategy(int baseDelay, int maxBackoffTime)
    {
      this.baseDelay = ValidationUtils.assertIsPositive(baseDelay, "Base delay");
      this.maxBackoffTime = ValidationUtils.assertIsPositive(maxBackoffTime, "Max backoff");
    }
    
    public long computeDelayBeforeNextRetry(RetryPolicyContext context)
    {
      int ceil = PredefinedBackoffStrategies.calculateExponentialDelay(context.retriesAttempted(), baseDelay, maxBackoffTime);
      return random.nextInt(ceil);
    }
  }
  
  public static class EqualJitterBackoffStrategy
    extends V2CompatibleBackoffStrategyAdapter
  {
    private final int baseDelay;
    private final int maxBackoffTime;
    private final Random random = new Random();
    
    public EqualJitterBackoffStrategy(int baseDelay, int maxBackoffTime)
    {
      this.baseDelay = ValidationUtils.assertIsPositive(baseDelay, "Base delay");
      this.maxBackoffTime = ValidationUtils.assertIsPositive(maxBackoffTime, "Max backoff");
    }
    
    public long computeDelayBeforeNextRetry(RetryPolicyContext context)
    {
      int ceil = PredefinedBackoffStrategies.calculateExponentialDelay(context.retriesAttempted(), baseDelay, maxBackoffTime);
      return ceil / 2 + random.nextInt(ceil / 2 + 1);
    }
  }
  
  public static class ExponentialBackoffStrategy
    extends V2CompatibleBackoffStrategyAdapter
  {
    private final int baseDelay;
    private final int maxBackoffTime;
    
    public ExponentialBackoffStrategy(int baseDelay, int maxBackoffTime)
    {
      this.baseDelay = ValidationUtils.assertIsPositive(baseDelay, "Base delay");
      this.maxBackoffTime = ValidationUtils.assertIsPositive(maxBackoffTime, "Max backoff");
    }
    
    public long computeDelayBeforeNextRetry(RetryPolicyContext context)
    {
      return PredefinedBackoffStrategies.calculateExponentialDelay(context.retriesAttempted(), baseDelay, maxBackoffTime);
    }
  }
  
  private static int calculateExponentialDelay(int retriesAttempted, int baseDelay, int maxBackoffTime)
  {
    int retries = Math.min(retriesAttempted, 30);
    return (int)Math.min((1L << retries) * baseDelay, maxBackoffTime);
  }
  
  public static class SDKDefaultBackoffStrategy
    extends V2CompatibleBackoffStrategyAdapter
  {
    private final BackoffStrategy fullJitterBackoffStrategy;
    private final BackoffStrategy equalJitterBackoffStrategy;
    
    public SDKDefaultBackoffStrategy()
    {
      fullJitterBackoffStrategy = new PredefinedBackoffStrategies.FullJitterBackoffStrategy(100, 20000);
      
      equalJitterBackoffStrategy = new PredefinedBackoffStrategies.EqualJitterBackoffStrategy(500, 20000);
    }
    
    public SDKDefaultBackoffStrategy(int baseDelay, int throttledBaseDelay, int maxBackoff)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedBackoffStrategies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
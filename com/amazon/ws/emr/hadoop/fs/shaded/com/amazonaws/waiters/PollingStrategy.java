package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

public class PollingStrategy
{
  private final RetryStrategy retryStrategy;
  private final DelayStrategy delayStrategy;
  
  public PollingStrategy(RetryStrategy retryStrategy, DelayStrategy delayStrategy)
  {
    this.retryStrategy = retryStrategy;
    this.delayStrategy = delayStrategy;
  }
  
  RetryStrategy getRetryStrategy()
  {
    return retryStrategy;
  }
  
  DelayStrategy getDelayStrategy()
  {
    return delayStrategy;
  }
  
  public static abstract interface DelayStrategy
  {
    public abstract void delayBeforeNextRetry(PollingStrategyContext paramPollingStrategyContext)
      throws InterruptedException;
  }
  
  public static abstract interface RetryStrategy
  {
    public abstract boolean shouldRetry(PollingStrategyContext paramPollingStrategyContext);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.PollingStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
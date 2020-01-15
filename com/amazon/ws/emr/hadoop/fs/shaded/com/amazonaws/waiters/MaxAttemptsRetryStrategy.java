package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

public class MaxAttemptsRetryStrategy
  implements PollingStrategy.RetryStrategy
{
  private final int defaultMaxAttempts;
  
  public MaxAttemptsRetryStrategy(int defaultMaxAttempts)
  {
    this.defaultMaxAttempts = defaultMaxAttempts;
  }
  
  public boolean shouldRetry(PollingStrategyContext pollingStrategyContext)
  {
    return pollingStrategyContext.getRetriesAttempted() < defaultMaxAttempts;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.MaxAttemptsRetryStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
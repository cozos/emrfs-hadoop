package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

public class FixedDelayStrategy
  implements PollingStrategy.DelayStrategy
{
  private final int defaultDelayInSeconds;
  
  public FixedDelayStrategy(int defaultDelayInSeconds)
  {
    this.defaultDelayInSeconds = defaultDelayInSeconds;
  }
  
  public void delayBeforeNextRetry(PollingStrategyContext pollingStrategyContext)
    throws InterruptedException
  {
    Thread.sleep(defaultDelayInSeconds * 1000);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.FixedDelayStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
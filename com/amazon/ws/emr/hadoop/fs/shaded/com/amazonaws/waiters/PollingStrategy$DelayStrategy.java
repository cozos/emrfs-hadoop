package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

public abstract interface PollingStrategy$DelayStrategy
{
  public abstract void delayBeforeNextRetry(PollingStrategyContext paramPollingStrategyContext)
    throws InterruptedException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.PollingStrategy.DelayStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import java.util.concurrent.atomic.AtomicLong;

class FutureRequestExecutionMetrics$DurationCounter
{
  private final AtomicLong count = new AtomicLong(0L);
  private final AtomicLong cumulativeDuration = new AtomicLong(0L);
  
  public void increment(long startTime)
  {
    count.incrementAndGet();
    cumulativeDuration.addAndGet(System.currentTimeMillis() - startTime);
  }
  
  public long count()
  {
    return count.get();
  }
  
  public long averageDuration()
  {
    long counter = count.get();
    return counter > 0L ? cumulativeDuration.get() / counter : 0L;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append("[count=").append(count()).append(", averageDuration=").append(averageDuration()).append("]");
    
    return builder.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.FutureRequestExecutionMetrics.DurationCounter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
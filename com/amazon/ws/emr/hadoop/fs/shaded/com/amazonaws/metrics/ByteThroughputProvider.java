package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

public abstract class ByteThroughputProvider
{
  private long duration;
  private int byteCount;
  private final ThroughputMetricType throughputType;
  
  protected ByteThroughputProvider(ThroughputMetricType type)
  {
    throughputType = type;
  }
  
  public ThroughputMetricType getThroughputMetricType()
  {
    return throughputType;
  }
  
  public int getByteCount()
  {
    return byteCount;
  }
  
  public long getDurationNano()
  {
    return duration;
  }
  
  public String getProviderId()
  {
    return super.toString();
  }
  
  protected void increment(int bytesDelta, long startTimeNano)
  {
    byteCount += bytesDelta;
    duration += System.nanoTime() - startTimeNano;
  }
  
  protected void reset()
  {
    byteCount = 0;
    duration = 0L;
  }
  
  public String toString()
  {
    return String.format("providerId=%s, throughputType=%s, byteCount=%d, duration=%d", new Object[] {
    
      getProviderId(), throughputType, Integer.valueOf(byteCount), Long.valueOf(duration) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ByteThroughputProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

import java.util.concurrent.TimeUnit;

class ByteThroughputHelper
  extends ByteThroughputProvider
{
  private static final int REPORT_INTERVAL_SECS = 10;
  
  ByteThroughputHelper(ThroughputMetricType type)
  {
    super(type);
  }
  
  long startTiming()
  {
    if (TimeUnit.NANOSECONDS.toSeconds(getDurationNano()) > 10L) {
      reportMetrics();
    }
    return System.nanoTime();
  }
  
  void reportMetrics()
  {
    if (getByteCount() > 0)
    {
      ServiceMetricCollector col = AwsSdkMetrics.getServiceMetricCollector();
      col.collectByteThroughput(this);
      reset();
    }
  }
  
  public void increment(int bytesDelta, long startTimeNano)
  {
    super.increment(bytesDelta, startTimeNano);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ByteThroughputHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
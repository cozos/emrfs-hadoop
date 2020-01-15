package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MetricFilterInputStream
  extends SdkFilterInputStream
{
  private final ByteThroughputHelper helper;
  
  public MetricFilterInputStream(ThroughputMetricType type, InputStream in)
  {
    super(in);
    helper = new ByteThroughputHelper(type);
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    abortIfNeeded();
    long startNano = helper.startTiming();
    int bytesRead = in.read(b, off, len);
    if (bytesRead > 0) {
      helper.increment(bytesRead, startNano);
    }
    return bytesRead;
  }
  
  public void close()
    throws IOException
  {
    helper.reportMetrics();
    in.close();
    abortIfNeeded();
  }
  
  public final boolean isMetricActivated()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.MetricFilterInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
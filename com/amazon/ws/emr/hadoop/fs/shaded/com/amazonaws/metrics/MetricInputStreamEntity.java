package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.MetricAware;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.InputStreamEntity;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MetricInputStreamEntity
  extends InputStreamEntity
{
  private static final int BUFFER_SIZE = 2048;
  private final ByteThroughputHelper helper;
  
  public MetricInputStreamEntity(ThroughputMetricType metricType, InputStream instream, long length)
  {
    super(instream, length);
    helper = new ByteThroughputHelper(metricType);
  }
  
  public MetricInputStreamEntity(ThroughputMetricType metricType, InputStream instream, long length, ContentType contentType)
  {
    super(instream, length, contentType);
    helper = new ByteThroughputHelper(metricType);
  }
  
  public void writeTo(OutputStream outstream)
    throws IOException
  {
    if ((outstream instanceof MetricAware))
    {
      MetricAware aware = (MetricAware)outstream;
      if (aware.isMetricActivated())
      {
        super.writeTo(outstream);
        return;
      }
    }
    writeToWithMetrics(outstream);
  }
  
  private void writeToWithMetrics(OutputStream outstream)
    throws IOException
  {
    if (outstream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    InputStream content = getContent();
    long length = getContentLength();
    InputStream instream = content;
    try
    {
      byte[] buffer = new byte['ࠀ'];
      if (length < 0L)
      {
        int l;
        while ((l = instream.read(buffer)) != -1)
        {
          long startNano = helper.startTiming();
          outstream.write(buffer, 0, l);
          helper.increment(l, startNano);
        }
      }
      long remaining = length;
      while (remaining > 0L)
      {
        int l = instream.read(buffer, 0, (int)Math.min(2048L, remaining));
        if (l == -1) {
          break;
        }
        long startNano = helper.startTiming();
        outstream.write(buffer, 0, l);
        helper.increment(l, startNano);
        remaining -= l;
      }
    }
    finally
    {
      helper.reportMetrics();
      instream.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.MetricInputStreamEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
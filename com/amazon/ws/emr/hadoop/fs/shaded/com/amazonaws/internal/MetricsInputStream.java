package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import java.io.IOException;
import java.io.InputStream;

public class MetricsInputStream
  extends DelegateInputStream
{
  private AWSRequestMetrics metrics;
  
  public MetricsInputStream(InputStream in)
  {
    super(in);
  }
  
  public void setMetrics(AWSRequestMetrics metrics)
  {
    this.metrics = metrics;
  }
  
  public int read()
    throws IOException
  {
    if (metrics != null) {
      metrics.startEvent(AWSRequestMetrics.Field.HttpSocketReadTime);
    }
    try
    {
      return in.read();
    }
    finally
    {
      if (metrics != null) {
        metrics.endEvent(AWSRequestMetrics.Field.HttpSocketReadTime);
      }
    }
  }
  
  public int read(byte[] b)
    throws IOException
  {
    if (metrics != null) {
      metrics.startEvent(AWSRequestMetrics.Field.HttpSocketReadTime);
    }
    try
    {
      return in.read(b);
    }
    finally
    {
      if (metrics != null) {
        metrics.endEvent(AWSRequestMetrics.Field.HttpSocketReadTime);
      }
    }
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    if (metrics != null) {
      metrics.startEvent(AWSRequestMetrics.Field.HttpSocketReadTime);
    }
    try
    {
      return in.read(b, off, len);
    }
    finally
    {
      if (metrics != null) {
        metrics.endEvent(AWSRequestMetrics.Field.HttpSocketReadTime);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.MetricsInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
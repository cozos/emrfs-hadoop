package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AbortedException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkRuntime;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SdkBufferedInputStream
  extends BufferedInputStream
  implements MetricAware
{
  public SdkBufferedInputStream(InputStream in)
  {
    super(in);
  }
  
  public SdkBufferedInputStream(InputStream in, int size)
  {
    super(in, size);
  }
  
  public boolean isMetricActivated()
  {
    if ((in instanceof MetricAware))
    {
      MetricAware metricAware = (MetricAware)in;
      return metricAware.isMetricActivated();
    }
    return false;
  }
  
  protected final void abortIfNeeded()
  {
    if (SdkRuntime.shouldAbort())
    {
      abort();
      throw new AbortedException();
    }
  }
  
  protected void abort() {}
  
  public int read()
    throws IOException
  {
    abortIfNeeded();
    return super.read();
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    abortIfNeeded();
    return super.read(b, off, len);
  }
  
  public long skip(long n)
    throws IOException
  {
    abortIfNeeded();
    return super.skip(n);
  }
  
  public int available()
    throws IOException
  {
    abortIfNeeded();
    return super.available();
  }
  
  public void close()
    throws IOException
  {
    super.close();
    abortIfNeeded();
  }
  
  public void mark(int readlimit)
  {
    abortIfNeeded();
    super.mark(readlimit);
  }
  
  public void reset()
    throws IOException
  {
    abortIfNeeded();
    super.reset();
  }
  
  public boolean markSupported()
  {
    abortIfNeeded();
    return super.markSupported();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkBufferedInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
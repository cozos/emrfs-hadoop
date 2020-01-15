package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AbortedException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkRuntime;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SdkFilterInputStream
  extends FilterInputStream
  implements MetricAware, Releasable
{
  private volatile boolean aborted = false;
  
  protected SdkFilterInputStream(InputStream in)
  {
    super(in);
  }
  
  @SdkProtectedApi
  public InputStream getDelegateStream()
  {
    return in;
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
  
  public void abort()
  {
    if ((in instanceof SdkFilterInputStream)) {
      ((SdkFilterInputStream)in).abort();
    }
    aborted = true;
  }
  
  protected boolean isAborted()
  {
    return aborted;
  }
  
  public int read()
    throws IOException
  {
    abortIfNeeded();
    return in.read();
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    abortIfNeeded();
    return in.read(b, off, len);
  }
  
  public long skip(long n)
    throws IOException
  {
    abortIfNeeded();
    return in.skip(n);
  }
  
  public int available()
    throws IOException
  {
    abortIfNeeded();
    return in.available();
  }
  
  public void close()
    throws IOException
  {
    in.close();
    abortIfNeeded();
  }
  
  public synchronized void mark(int readlimit)
  {
    abortIfNeeded();
    in.mark(readlimit);
  }
  
  public synchronized void reset()
    throws IOException
  {
    abortIfNeeded();
    in.reset();
  }
  
  public boolean markSupported()
  {
    abortIfNeeded();
    return in.markSupported();
  }
  
  public void release()
  {
    SdkIOUtils.closeQuietly(this);
    if ((in instanceof Releasable))
    {
      Releasable r = (Releasable)in;
      r.release();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
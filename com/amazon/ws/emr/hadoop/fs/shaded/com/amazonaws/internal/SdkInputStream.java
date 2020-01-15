package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AbortedException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkRuntime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.io.InputStream;

public abstract class SdkInputStream
  extends InputStream
  implements MetricAware, Releasable
{
  protected abstract InputStream getWrappedInputStream();
  
  public final boolean isMetricActivated()
  {
    InputStream in = getWrappedInputStream();
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
      try
      {
        abort();
      }
      catch (IOException e)
      {
        LogFactory.getLog(getClass()).debug("FYI", e);
      }
      throw new AbortedException();
    }
  }
  
  protected void abort()
    throws IOException
  {}
  
  public void release()
  {
    IOUtils.closeQuietly(this, null);
    InputStream in = getWrappedInputStream();
    if ((in instanceof Releasable))
    {
      Releasable r = (Releasable)in;
      r.release();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
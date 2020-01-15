package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public class SdkFilterOutputStream
  extends FilterOutputStream
  implements MetricAware, Releasable
{
  public SdkFilterOutputStream(OutputStream out)
  {
    super(out);
  }
  
  public boolean isMetricActivated()
  {
    if ((out instanceof MetricAware))
    {
      MetricAware metricAware = (MetricAware)out;
      return metricAware.isMetricActivated();
    }
    return false;
  }
  
  public final void release()
  {
    IOUtils.closeQuietly(this, null);
    if ((out instanceof Releasable))
    {
      Releasable r = (Releasable)out;
      r.release();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
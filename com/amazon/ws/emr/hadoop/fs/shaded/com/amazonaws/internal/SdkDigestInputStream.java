package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class SdkDigestInputStream
  extends DigestInputStream
  implements MetricAware, Releasable
{
  private static final int SKIP_BUF_SIZE = 2048;
  
  public SdkDigestInputStream(InputStream stream, MessageDigest digest)
  {
    super(stream, digest);
  }
  
  public final boolean isMetricActivated()
  {
    if ((in instanceof MetricAware))
    {
      MetricAware metricAware = (MetricAware)in;
      return metricAware.isMetricActivated();
    }
    return false;
  }
  
  public final long skip(long n)
    throws IOException
  {
    if (n <= 0L) {
      return n;
    }
    byte[] b = new byte[(int)Math.min(2048L, n)];
    long m = n;
    while (m > 0L)
    {
      int len = read(b, 0, (int)Math.min(m, b.length));
      if (len == -1) {
        return n - m;
      }
      m -= len;
    }
    assert (m == 0L);
    return n;
  }
  
  public final void release()
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkDigestInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
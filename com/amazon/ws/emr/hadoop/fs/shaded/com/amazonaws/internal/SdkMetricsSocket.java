package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SdkMetricsSocket
  extends DelegateSocket
{
  private MetricsInputStream metricsIS;
  
  public SdkMetricsSocket(Socket sock)
  {
    super(sock);
  }
  
  public void setMetrics(AWSRequestMetrics metrics)
  {
    if (metricsIS == null) {
      throw new IllegalStateException("The underlying input stream must be initialized!");
    }
    metricsIS.setMetrics(metrics);
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    metricsIS = new MetricsInputStream(sock.getInputStream());
    return metricsIS;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkMetricsSocket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
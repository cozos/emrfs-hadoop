package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import java.io.IOException;
import java.io.InputStream;
import javax.net.ssl.SSLSocket;

public class SdkSSLMetricsSocket
  extends DelegateSSLSocket
{
  private MetricsInputStream metricsIS;
  
  public SdkSSLMetricsSocket(SSLSocket sock)
  {
    super(sock);
  }
  
  public void setMetrics(AWSRequestMetrics metrics)
    throws IOException
  {
    getInputStream();
    metricsIS.setMetrics(metrics);
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    if (metricsIS == null) {
      metricsIS = new MetricsInputStream(sock.getInputStream());
    }
    return metricsIS;
  }
  
  @SdkTestInternalApi
  MetricsInputStream getMetricsInputStream()
  {
    return metricsIS;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkSSLMetricsSocket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
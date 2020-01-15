package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.ConnectionSocketFactory;

@NotThreadSafe
public final class ApacheHttpClientConfig
{
  private ConnectionSocketFactory sslSocketFactory;
  
  ApacheHttpClientConfig() {}
  
  ApacheHttpClientConfig(ApacheHttpClientConfig that)
  {
    sslSocketFactory = sslSocketFactory;
  }
  
  public ConnectionSocketFactory getSslSocketFactory()
  {
    return sslSocketFactory;
  }
  
  public void setSslSocketFactory(ConnectionSocketFactory sslSocketFactory)
  {
    this.sslSocketFactory = sslSocketFactory;
  }
  
  public ApacheHttpClientConfig withSslSocketFactory(ConnectionSocketFactory sslSocketFactory)
  {
    this.sslSocketFactory = sslSocketFactory;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ApacheHttpClientConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
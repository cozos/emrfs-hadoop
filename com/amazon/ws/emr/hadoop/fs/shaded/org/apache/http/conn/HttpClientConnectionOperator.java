package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.SocketConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;

public abstract interface HttpClientConnectionOperator
{
  public abstract void connect(ManagedHttpClientConnection paramManagedHttpClientConnection, HttpHost paramHttpHost, InetSocketAddress paramInetSocketAddress, int paramInt, SocketConfig paramSocketConfig, HttpContext paramHttpContext)
    throws IOException;
  
  public abstract void upgrade(ManagedHttpClientConnection paramManagedHttpClientConnection, HttpHost paramHttpHost, HttpContext paramHttpContext)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
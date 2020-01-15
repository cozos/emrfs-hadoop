package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.net.InetAddress;
import java.net.InetSocketAddress;

@Deprecated
public class HttpInetSocketAddress
  extends InetSocketAddress
{
  private static final long serialVersionUID = -6650701828361907957L;
  private final HttpHost httphost;
  
  public HttpInetSocketAddress(HttpHost httphost, InetAddress addr, int port)
  {
    super(addr, port);
    Args.notNull(httphost, "HTTP host");
    this.httphost = httphost;
  }
  
  public HttpHost getHttpHost()
  {
    return httphost;
  }
  
  public String toString()
  {
    return httphost.getHostName() + ":" + getPort();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpInetSocketAddress
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.util.Arrays;

public class HttpHostConnectException
  extends ConnectException
{
  private static final long serialVersionUID = -3194482710275220224L;
  private final HttpHost host;
  
  @Deprecated
  public HttpHostConnectException(HttpHost host, ConnectException cause)
  {
    this(cause, host, (InetAddress[])null);
  }
  
  public HttpHostConnectException(IOException cause, HttpHost host, InetAddress... remoteAddresses)
  {
    super("Connect to " + (host != null ? host.toHostString() : "remote host") + ((remoteAddresses != null) && (remoteAddresses.length > 0) ? " " + Arrays.asList(remoteAddresses) : "") + ((cause != null) && (cause.getMessage() != null) ? " failed: " + cause.getMessage() : " refused"));
    
    this.host = host;
    initCause(cause);
  }
  
  public HttpHost getHost()
  {
    return host;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpHostConnectException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
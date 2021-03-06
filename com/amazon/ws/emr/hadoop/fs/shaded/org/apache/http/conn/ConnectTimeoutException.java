package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.util.Arrays;

public class ConnectTimeoutException
  extends InterruptedIOException
{
  private static final long serialVersionUID = -4816682903149535989L;
  private final HttpHost host;
  
  public ConnectTimeoutException()
  {
    host = null;
  }
  
  public ConnectTimeoutException(String message)
  {
    super(message);
    host = null;
  }
  
  public ConnectTimeoutException(IOException cause, HttpHost host, InetAddress... remoteAddresses)
  {
    super("Connect to " + (host != null ? host.toHostString() : "remote host") + ((remoteAddresses != null) && (remoteAddresses.length > 0) ? " " + Arrays.asList(remoteAddresses) : "") + ((cause != null) && (cause.getMessage() != null) ? " failed: " + cause.getMessage() : " timed out"));
    
    this.host = host;
    initCause(cause);
  }
  
  public HttpHost getHost()
  {
    return host;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectTimeoutException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
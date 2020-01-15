package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class SchemeLayeredSocketFactoryAdaptor2
  implements SchemeLayeredSocketFactory
{
  private final LayeredSchemeSocketFactory factory;
  
  SchemeLayeredSocketFactoryAdaptor2(LayeredSchemeSocketFactory factory)
  {
    this.factory = factory;
  }
  
  public Socket createSocket(HttpParams params)
    throws IOException
  {
    return factory.createSocket(params);
  }
  
  public Socket connectSocket(Socket sock, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpParams params)
    throws IOException, UnknownHostException, ConnectTimeoutException
  {
    return factory.connectSocket(sock, remoteAddress, localAddress, params);
  }
  
  public boolean isSecure(Socket sock)
    throws IllegalArgumentException
  {
    return factory.isSecure(sock);
  }
  
  public Socket createLayeredSocket(Socket socket, String target, int port, HttpParams params)
    throws IOException, UnknownHostException
  {
    return factory.createLayeredSocket(socket, target, port, true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeLayeredSocketFactoryAdaptor2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
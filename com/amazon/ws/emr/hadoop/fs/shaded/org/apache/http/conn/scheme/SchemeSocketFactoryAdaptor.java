package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class SchemeSocketFactoryAdaptor
  implements SchemeSocketFactory
{
  private final SocketFactory factory;
  
  SchemeSocketFactoryAdaptor(SocketFactory factory)
  {
    this.factory = factory;
  }
  
  public Socket connectSocket(Socket sock, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpParams params)
    throws IOException, UnknownHostException, ConnectTimeoutException
  {
    String host = remoteAddress.getHostName();
    int port = remoteAddress.getPort();
    InetAddress local = null;
    int localPort = 0;
    if (localAddress != null)
    {
      local = localAddress.getAddress();
      localPort = localAddress.getPort();
    }
    return factory.connectSocket(sock, host, port, local, localPort, params);
  }
  
  public Socket createSocket(HttpParams params)
    throws IOException
  {
    return factory.createSocket();
  }
  
  public boolean isSecure(Socket sock)
    throws IllegalArgumentException
  {
    return factory.isSecure(sock);
  }
  
  public SocketFactory getFactory()
  {
    return factory;
  }
  
  public boolean equals(Object obj)
  {
    if (obj == null) {
      return false;
    }
    if (this == obj) {
      return true;
    }
    if ((obj instanceof SchemeSocketFactoryAdaptor)) {
      return factory.equals(factory);
    }
    return factory.equals(obj);
  }
  
  public int hashCode()
  {
    return factory.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeSocketFactoryAdaptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
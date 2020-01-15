package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.BasicHttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class SocketFactoryAdaptor
  implements SocketFactory
{
  private final SchemeSocketFactory factory;
  
  SocketFactoryAdaptor(SchemeSocketFactory factory)
  {
    this.factory = factory;
  }
  
  public Socket createSocket()
    throws IOException
  {
    HttpParams params = new BasicHttpParams();
    return factory.createSocket(params);
  }
  
  public Socket connectSocket(Socket socket, String host, int port, InetAddress localAddress, int localPort, HttpParams params)
    throws IOException, UnknownHostException, ConnectTimeoutException
  {
    InetSocketAddress local = null;
    if ((localAddress != null) || (localPort > 0)) {
      local = new InetSocketAddress(localAddress, localPort > 0 ? localPort : 0);
    }
    InetAddress remoteAddress = InetAddress.getByName(host);
    InetSocketAddress remote = new InetSocketAddress(remoteAddress, port);
    return factory.connectSocket(socket, remote, local, params);
  }
  
  public boolean isSecure(Socket socket)
    throws IllegalArgumentException
  {
    return factory.isSecure(socket);
  }
  
  public SchemeSocketFactory getFactory()
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
    if ((obj instanceof SocketFactoryAdaptor)) {
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SocketFactoryAdaptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
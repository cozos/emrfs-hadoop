package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class LayeredSocketFactoryAdaptor
  extends SocketFactoryAdaptor
  implements LayeredSocketFactory
{
  private final LayeredSchemeSocketFactory factory;
  
  LayeredSocketFactoryAdaptor(LayeredSchemeSocketFactory factory)
  {
    super(factory);
    this.factory = factory;
  }
  
  public Socket createSocket(Socket socket, String host, int port, boolean autoClose)
    throws IOException, UnknownHostException
  {
    return factory.createLayeredSocket(socket, host, port, autoClose);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.LayeredSocketFactoryAdaptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
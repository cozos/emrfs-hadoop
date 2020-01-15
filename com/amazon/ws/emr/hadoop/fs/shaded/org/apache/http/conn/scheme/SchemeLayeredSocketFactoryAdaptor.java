package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class SchemeLayeredSocketFactoryAdaptor
  extends SchemeSocketFactoryAdaptor
  implements SchemeLayeredSocketFactory
{
  private final LayeredSocketFactory factory;
  
  SchemeLayeredSocketFactoryAdaptor(LayeredSocketFactory factory)
  {
    super(factory);
    this.factory = factory;
  }
  
  public Socket createLayeredSocket(Socket socket, String target, int port, HttpParams params)
    throws IOException, UnknownHostException
  {
    return factory.createSocket(socket, target, port, true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeLayeredSocketFactoryAdaptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
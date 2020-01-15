package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class PlainConnectionSocketFactory
  implements ConnectionSocketFactory
{
  public static final PlainConnectionSocketFactory INSTANCE = new PlainConnectionSocketFactory();
  
  public static PlainConnectionSocketFactory getSocketFactory()
  {
    return INSTANCE;
  }
  
  public Socket createSocket(HttpContext context)
    throws IOException
  {
    return new Socket();
  }
  
  public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpContext context)
    throws IOException
  {
    Socket sock = socket != null ? socket : createSocket(context);
    if (localAddress != null) {
      sock.bind(localAddress);
    }
    try
    {
      sock.connect(remoteAddress, connectTimeout);
    }
    catch (IOException ex)
    {
      try
      {
        sock.close();
      }
      catch (IOException ignore) {}
      throw ex;
    }
    return sock;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.PlainConnectionSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
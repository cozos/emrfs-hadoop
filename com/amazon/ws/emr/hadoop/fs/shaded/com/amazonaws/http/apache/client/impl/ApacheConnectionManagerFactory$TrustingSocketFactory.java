package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

class ApacheConnectionManagerFactory$TrustingSocketFactory
  implements LayeredConnectionSocketFactory
{
  private SSLContext sslcontext = null;
  
  private static SSLContext createSSLContext()
    throws IOException
  {
    try
    {
      SSLContext context = SSLContext.getInstance("TLS");
      context.init(null, new TrustManager[] { new ApacheConnectionManagerFactory.TrustingX509TrustManager(null) }, null);
      return context;
    }
    catch (Exception e)
    {
      throw new IOException(e.getMessage(), e);
    }
  }
  
  public Socket createLayeredSocket(Socket socket, String target, int port, HttpContext context)
    throws IOException, UnknownHostException
  {
    return getSSLContext().getSocketFactory().createSocket(socket, target, port, true);
  }
  
  public Socket createSocket(HttpContext context)
    throws IOException
  {
    return getSSLContext().getSocketFactory().createSocket();
  }
  
  public Socket connectSocket(int connectTimeout, Socket sock, HttpHost host, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpContext context)
    throws IOException
  {
    SSLSocket sslsock = (SSLSocket)(sock != null ? sock : createSocket(context));
    if (localAddress != null) {
      sslsock.bind(localAddress);
    }
    sslsock.connect(remoteAddress, connectTimeout);
    
    return sslsock;
  }
  
  private SSLContext getSSLContext()
    throws IOException
  {
    if (sslcontext == null) {
      sslcontext = createSSLContext();
    }
    return sslcontext;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl.ApacheConnectionManagerFactory.TrustingSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
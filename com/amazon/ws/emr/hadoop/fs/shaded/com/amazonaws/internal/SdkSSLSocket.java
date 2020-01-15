package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.net.SocketAddress;
import javax.net.ssl.SSLSocket;

public class SdkSSLSocket
  extends DelegateSSLSocket
{
  private static final Log log = LogFactory.getLog(SdkSSLSocket.class);
  
  public SdkSSLSocket(SSLSocket sock)
  {
    super(sock);
    if (log.isDebugEnabled()) {
      log.debug("created: " + endpoint());
    }
  }
  
  private String endpoint()
  {
    return sock.getInetAddress() + ":" + sock.getPort();
  }
  
  public void connect(SocketAddress endpoint)
    throws IOException
  {
    if (log.isDebugEnabled()) {
      log.debug("connecting to: " + endpoint);
    }
    sock.connect(endpoint);
    if (log.isDebugEnabled()) {
      log.debug("connected to: " + endpoint());
    }
  }
  
  public void connect(SocketAddress endpoint, int timeout)
    throws IOException
  {
    if (log.isDebugEnabled()) {
      log.debug("connecting to: " + endpoint);
    }
    sock.connect(endpoint, timeout);
    if (log.isDebugEnabled()) {
      log.debug("connected to: " + endpoint());
    }
  }
  
  public void close()
    throws IOException
  {
    if (log.isDebugEnabled()) {
      log.debug("closing " + endpoint());
    }
    sock.close();
  }
  
  public void shutdownInput()
    throws IOException
  {
    if (log.isDebugEnabled()) {
      log.debug("shutting down input of " + endpoint());
    }
    sock.shutdownInput();
  }
  
  public void shutdownOutput()
    throws IOException
  {
    if (log.isDebugEnabled()) {
      log.debug("shutting down output of " + endpoint());
    }
    sock.shutdownOutput();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkSSLSocket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;

public class DelegateSocket
  extends Socket
{
  protected final Socket sock;
  
  public DelegateSocket(Socket sock)
  {
    this.sock = sock;
  }
  
  public void connect(SocketAddress endpoint)
    throws IOException
  {
    sock.connect(endpoint);
  }
  
  public void connect(SocketAddress endpoint, int timeout)
    throws IOException
  {
    sock.connect(endpoint, timeout);
  }
  
  public void bind(SocketAddress bindpoint)
    throws IOException
  {
    sock.bind(bindpoint);
  }
  
  public InetAddress getInetAddress()
  {
    return sock.getInetAddress();
  }
  
  public InetAddress getLocalAddress()
  {
    return sock.getLocalAddress();
  }
  
  public int getPort()
  {
    return sock.getPort();
  }
  
  public int getLocalPort()
  {
    return sock.getLocalPort();
  }
  
  public SocketAddress getRemoteSocketAddress()
  {
    return sock.getRemoteSocketAddress();
  }
  
  public SocketAddress getLocalSocketAddress()
  {
    return sock.getLocalSocketAddress();
  }
  
  public SocketChannel getChannel()
  {
    return sock.getChannel();
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return sock.getInputStream();
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return sock.getOutputStream();
  }
  
  public void setTcpNoDelay(boolean on)
    throws SocketException
  {
    sock.setTcpNoDelay(on);
  }
  
  public boolean getTcpNoDelay()
    throws SocketException
  {
    return sock.getTcpNoDelay();
  }
  
  public void setSoLinger(boolean on, int linger)
    throws SocketException
  {
    sock.setSoLinger(on, linger);
  }
  
  public int getSoLinger()
    throws SocketException
  {
    return sock.getSoLinger();
  }
  
  public void sendUrgentData(int data)
    throws IOException
  {
    sock.sendUrgentData(data);
  }
  
  public void setOOBInline(boolean on)
    throws SocketException
  {
    sock.setOOBInline(on);
  }
  
  public boolean getOOBInline()
    throws SocketException
  {
    return sock.getOOBInline();
  }
  
  public void setSoTimeout(int timeout)
    throws SocketException
  {
    sock.setSoTimeout(timeout);
  }
  
  public int getSoTimeout()
    throws SocketException
  {
    return sock.getSoTimeout();
  }
  
  public void setSendBufferSize(int size)
    throws SocketException
  {
    sock.setSendBufferSize(size);
  }
  
  public int getSendBufferSize()
    throws SocketException
  {
    return sock.getSendBufferSize();
  }
  
  public void setReceiveBufferSize(int size)
    throws SocketException
  {
    sock.setReceiveBufferSize(size);
  }
  
  public int getReceiveBufferSize()
    throws SocketException
  {
    return sock.getReceiveBufferSize();
  }
  
  public void setKeepAlive(boolean on)
    throws SocketException
  {
    sock.setKeepAlive(on);
  }
  
  public boolean getKeepAlive()
    throws SocketException
  {
    return sock.getKeepAlive();
  }
  
  public void setTrafficClass(int tc)
    throws SocketException
  {
    sock.setTrafficClass(tc);
  }
  
  public int getTrafficClass()
    throws SocketException
  {
    return sock.getTrafficClass();
  }
  
  public void setReuseAddress(boolean on)
    throws SocketException
  {
    sock.setReuseAddress(on);
  }
  
  public boolean getReuseAddress()
    throws SocketException
  {
    return sock.getReuseAddress();
  }
  
  public void close()
    throws IOException
  {
    sock.close();
  }
  
  public void shutdownInput()
    throws IOException
  {
    sock.shutdownInput();
  }
  
  public void shutdownOutput()
    throws IOException
  {
    sock.shutdownOutput();
  }
  
  public String toString()
  {
    return sock.toString();
  }
  
  public boolean isConnected()
  {
    return sock.isConnected();
  }
  
  public boolean isBound()
  {
    return sock.isBound();
  }
  
  public boolean isClosed()
  {
    return sock.isClosed();
  }
  
  public boolean isInputShutdown()
  {
    return sock.isInputShutdown();
  }
  
  public boolean isOutputShutdown()
  {
    return sock.isOutputShutdown();
  }
  
  public void setPerformancePreferences(int connectionTime, int latency, int bandwidth)
  {
    sock.setPerformancePreferences(connectionTime, latency, bandwidth);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.DelegateSocket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
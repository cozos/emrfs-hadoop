package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpConnectionParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Asserts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public final class MultihomePlainSocketFactory
  implements SocketFactory
{
  private static final MultihomePlainSocketFactory DEFAULT_FACTORY = new MultihomePlainSocketFactory();
  
  public static MultihomePlainSocketFactory getSocketFactory()
  {
    return DEFAULT_FACTORY;
  }
  
  public Socket createSocket()
  {
    return new Socket();
  }
  
  public Socket connectSocket(Socket socket, String host, int port, InetAddress localAddress, int localPort, HttpParams params)
    throws IOException
  {
    Args.notNull(host, "Target host");
    Args.notNull(params, "HTTP parameters");
    
    Socket sock = socket;
    if (sock == null) {
      sock = createSocket();
    }
    if ((localAddress != null) || (localPort > 0))
    {
      InetSocketAddress isa = new InetSocketAddress(localAddress, localPort > 0 ? localPort : 0);
      
      sock.bind(isa);
    }
    int timeout = HttpConnectionParams.getConnectionTimeout(params);
    
    InetAddress[] inetadrs = InetAddress.getAllByName(host);
    List<InetAddress> addresses = new ArrayList(inetadrs.length);
    addresses.addAll(Arrays.asList(inetadrs));
    Collections.shuffle(addresses);
    
    IOException lastEx = null;
    for (InetAddress remoteAddress : addresses) {
      try
      {
        sock.connect(new InetSocketAddress(remoteAddress, port), timeout);
      }
      catch (SocketTimeoutException ex)
      {
        throw new ConnectTimeoutException("Connect to " + remoteAddress + " timed out");
      }
      catch (IOException ex)
      {
        sock = new Socket();
        
        lastEx = ex;
      }
    }
    if (lastEx != null) {
      throw lastEx;
    }
    return sock;
  }
  
  public final boolean isSecure(Socket sock)
    throws IllegalArgumentException
  {
    Args.notNull(sock, "Socket");
    
    Asserts.check(!sock.isClosed(), "Socket is closed");
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.MultihomePlainSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
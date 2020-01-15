package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.Lookup;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.SocketConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.DnsResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpHostConnectException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedHttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.SchemePortResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.UnsupportedSchemeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.ConnectionSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.SocketTimeoutException;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultHttpClientConnectionOperator
  implements HttpClientConnectionOperator
{
  static final String SOCKET_FACTORY_REGISTRY = "http.socket-factory-registry";
  private final Log log = LogFactory.getLog(getClass());
  private final Lookup<ConnectionSocketFactory> socketFactoryRegistry;
  private final SchemePortResolver schemePortResolver;
  private final DnsResolver dnsResolver;
  
  public DefaultHttpClientConnectionOperator(Lookup<ConnectionSocketFactory> socketFactoryRegistry, SchemePortResolver schemePortResolver, DnsResolver dnsResolver)
  {
    Args.notNull(socketFactoryRegistry, "Socket factory registry");
    this.socketFactoryRegistry = socketFactoryRegistry;
    this.schemePortResolver = (schemePortResolver != null ? schemePortResolver : DefaultSchemePortResolver.INSTANCE);
    
    this.dnsResolver = (dnsResolver != null ? dnsResolver : SystemDefaultDnsResolver.INSTANCE);
  }
  
  private Lookup<ConnectionSocketFactory> getSocketFactoryRegistry(HttpContext context)
  {
    Lookup<ConnectionSocketFactory> reg = (Lookup)context.getAttribute("http.socket-factory-registry");
    if (reg == null) {
      reg = socketFactoryRegistry;
    }
    return reg;
  }
  
  public void connect(ManagedHttpClientConnection conn, HttpHost host, InetSocketAddress localAddress, int connectTimeout, SocketConfig socketConfig, HttpContext context)
    throws IOException
  {
    Lookup<ConnectionSocketFactory> registry = getSocketFactoryRegistry(context);
    ConnectionSocketFactory sf = (ConnectionSocketFactory)registry.lookup(host.getSchemeName());
    if (sf == null) {
      throw new UnsupportedSchemeException(host.getSchemeName() + " protocol is not supported");
    }
    InetAddress[] addresses = host.getAddress() != null ? new InetAddress[] { host.getAddress() } : dnsResolver.resolve(host.getHostName());
    
    int port = schemePortResolver.resolve(host);
    for (int i = 0; i < addresses.length; i++)
    {
      InetAddress address = addresses[i];
      boolean last = i == addresses.length - 1;
      
      Socket sock = sf.createSocket(context);
      sock.setSoTimeout(socketConfig.getSoTimeout());
      sock.setReuseAddress(socketConfig.isSoReuseAddress());
      sock.setTcpNoDelay(socketConfig.isTcpNoDelay());
      sock.setKeepAlive(socketConfig.isSoKeepAlive());
      if (socketConfig.getRcvBufSize() > 0) {
        sock.setReceiveBufferSize(socketConfig.getRcvBufSize());
      }
      if (socketConfig.getSndBufSize() > 0) {
        sock.setSendBufferSize(socketConfig.getSndBufSize());
      }
      int linger = socketConfig.getSoLinger();
      if (linger >= 0) {
        sock.setSoLinger(true, linger);
      }
      conn.bind(sock);
      
      InetSocketAddress remoteAddress = new InetSocketAddress(address, port);
      if (log.isDebugEnabled()) {
        log.debug("Connecting to " + remoteAddress);
      }
      try
      {
        sock = sf.connectSocket(connectTimeout, sock, host, remoteAddress, localAddress, context);
        
        conn.bind(sock);
        if (log.isDebugEnabled()) {
          log.debug("Connection established " + conn);
        }
        return;
      }
      catch (SocketTimeoutException ex)
      {
        if (last) {
          throw new ConnectTimeoutException(ex, host, addresses);
        }
      }
      catch (ConnectException ex)
      {
        if (last)
        {
          String msg = ex.getMessage();
          if ("Connection timed out".equals(msg)) {
            throw new ConnectTimeoutException(ex, host, addresses);
          }
          throw new HttpHostConnectException(ex, host, addresses);
        }
      }
      catch (NoRouteToHostException ex)
      {
        if (last) {
          throw ex;
        }
      }
      if (log.isDebugEnabled()) {
        log.debug("Connect to " + remoteAddress + " timed out. " + "Connection will be retried using another IP address");
      }
    }
  }
  
  public void upgrade(ManagedHttpClientConnection conn, HttpHost host, HttpContext context)
    throws IOException
  {
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    Lookup<ConnectionSocketFactory> registry = getSocketFactoryRegistry(clientContext);
    ConnectionSocketFactory sf = (ConnectionSocketFactory)registry.lookup(host.getSchemeName());
    if (sf == null) {
      throw new UnsupportedSchemeException(host.getSchemeName() + " protocol is not supported");
    }
    if (!(sf instanceof LayeredConnectionSocketFactory)) {
      throw new UnsupportedSchemeException(host.getSchemeName() + " protocol does not support connection upgrade");
    }
    LayeredConnectionSocketFactory lsf = (LayeredConnectionSocketFactory)sf;
    Socket sock = conn.getSocket();
    int port = schemePortResolver.resolve(host);
    sock = lsf.createLayeredSocket(sock, host.getHostName(), port, context);
    conn.bind(sock);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.DefaultHttpClientConnectionOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
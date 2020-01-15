package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.utils.HttpContextUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkMetricsSocket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkSSLMetricsSocket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkSSLSocket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkSocket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.AwsSdkMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.JavaVersionParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;

@ThreadSafe
public class SdkTLSSocketFactory
  extends SSLConnectionSocketFactory
{
  private static final Log LOG = LogFactory.getLog(SdkTLSSocketFactory.class);
  private final SSLContext sslContext;
  private final MasterSecretValidators.MasterSecretValidator masterSecretValidator;
  private final ShouldClearSslSessionPredicate shouldClearSslSessionsPredicate;
  
  public SdkTLSSocketFactory(SSLContext sslContext, HostnameVerifier hostnameVerifier)
  {
    super(sslContext, hostnameVerifier);
    if (sslContext == null) {
      throw new IllegalArgumentException("sslContext must not be null. Use SSLContext.getDefault() if you are unsure.");
    }
    this.sslContext = sslContext;
    masterSecretValidator = MasterSecretValidators.getMasterSecretValidator();
    shouldClearSslSessionsPredicate = new ShouldClearSslSessionPredicate(JavaVersionParser.getCurrentJavaVersion());
  }
  
  public Socket createSocket(HttpContext ctx)
    throws IOException
  {
    if (HttpContextUtils.disableSocketProxy(ctx)) {
      return new Socket(Proxy.NO_PROXY);
    }
    return super.createSocket(ctx);
  }
  
  protected final void prepareSocket(SSLSocket socket)
  {
    String[] supported = socket.getSupportedProtocols();
    String[] enabled = socket.getEnabledProtocols();
    if (LOG.isDebugEnabled()) {
      LOG.debug("socket.getSupportedProtocols(): " + Arrays.toString(supported) + ", socket.getEnabledProtocols(): " + 
        Arrays.toString(enabled));
    }
    List<String> target = new ArrayList();
    TLSProtocol[] values;
    int i;
    String pname;
    if (supported != null)
    {
      values = TLSProtocol.values();
      for (i = 0; i < values.length; i++)
      {
        pname = values[i].getProtocolName();
        if (existsIn(pname, supported)) {
          target.add(pname);
        }
      }
    }
    if (enabled != null)
    {
      values = enabled;i = values.length;
      for (pname = 0; pname < i; pname++)
      {
        String pname = values[pname];
        if (!target.contains(pname)) {
          target.add(pname);
        }
      }
    }
    if (target.size() > 0)
    {
      String[] enabling = (String[])target.toArray(new String[target.size()]);
      socket.setEnabledProtocols(enabling);
      if (LOG.isDebugEnabled()) {
        LOG.debug("TLS protocol enabled for SSL handshake: " + Arrays.toString(enabling));
      }
    }
  }
  
  private boolean existsIn(String element, String[] a)
  {
    for (String s : a) {
      if (element.equals(s)) {
        return true;
      }
    }
    return false;
  }
  
  public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpContext context)
    throws IOException
  {
    if (LOG.isDebugEnabled()) {
      LOG.debug("connecting to " + remoteAddress.getAddress() + ":" + remoteAddress.getPort());
    }
    try
    {
      Socket connectedSocket = super.connectSocket(connectTimeout, socket, host, remoteAddress, localAddress, context);
      if (!masterSecretValidator.isMasterSecretValid(connectedSocket)) {
        throw ((IllegalStateException)log(new IllegalStateException("Invalid SSL master secret")));
      }
    }
    catch (SSLException sslEx)
    {
      if (shouldClearSslSessionsPredicate.test(sslEx))
      {
        if (LOG.isDebugEnabled()) {
          LOG.debug("connection failed due to SSL error, clearing TLS session cache", sslEx);
        }
        clearSessionCache(sslContext.getClientSessionContext(), remoteAddress);
      }
      throw sslEx;
    }
    Socket connectedSocket;
    if ((connectedSocket instanceof SSLSocket))
    {
      SdkSSLSocket sslSocket = new SdkSSLSocket((SSLSocket)connectedSocket);
      return AwsSdkMetrics.isHttpSocketReadMetricEnabled() ? new SdkSSLMetricsSocket(sslSocket) : sslSocket;
    }
    SdkSocket sdkSocket = new SdkSocket(connectedSocket);
    return AwsSdkMetrics.isHttpSocketReadMetricEnabled() ? new SdkMetricsSocket(sdkSocket) : sdkSocket;
  }
  
  private void clearSessionCache(SSLSessionContext sessionContext, InetSocketAddress remoteAddress)
  {
    String hostName = remoteAddress.getHostName();
    int port = remoteAddress.getPort();
    Enumeration<byte[]> ids = sessionContext.getIds();
    if (ids == null) {
      return;
    }
    while (ids.hasMoreElements())
    {
      byte[] id = (byte[])ids.nextElement();
      SSLSession session = sessionContext.getSession(id);
      if ((session != null) && (session.getPeerHost() != null) && (session.getPeerHost().equalsIgnoreCase(hostName)) && 
        (session.getPeerPort() == port))
      {
        session.invalidate();
        if (LOG.isDebugEnabled()) {
          LOG.debug("Invalidated session " + session);
        }
      }
    }
  }
  
  private <T extends Throwable> T log(T t)
  {
    if (LOG.isDebugEnabled()) {
      LOG.debug("", t);
    }
    return t;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl.SdkTLSSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
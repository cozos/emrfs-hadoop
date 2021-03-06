package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpInetSocketAddress;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.HostNameResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.LayeredSchemeSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.LayeredSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeLayeredSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpConnectionParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Asserts;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

@Deprecated
@Contract(threading=ThreadingBehavior.SAFE_CONDITIONAL)
public class SSLSocketFactory
  implements LayeredConnectionSocketFactory, SchemeLayeredSocketFactory, LayeredSchemeSocketFactory, LayeredSocketFactory
{
  public static final String TLS = "TLS";
  public static final String SSL = "SSL";
  public static final String SSLV2 = "SSLv2";
  public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = new AllowAllHostnameVerifier();
  public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
  public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
  private final javax.net.ssl.SSLSocketFactory socketfactory;
  private final HostNameResolver nameResolver;
  private volatile X509HostnameVerifier hostnameVerifier;
  private final String[] supportedProtocols;
  private final String[] supportedCipherSuites;
  
  public static SSLSocketFactory getSocketFactory()
    throws SSLInitializationException
  {
    return new SSLSocketFactory(SSLContexts.createDefault(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  private static String[] split(String s)
  {
    if (TextUtils.isBlank(s)) {
      return null;
    }
    return s.split(" *, *");
  }
  
  public static SSLSocketFactory getSystemSocketFactory()
    throws SSLInitializationException
  {
    return new SSLSocketFactory((javax.net.ssl.SSLSocketFactory)javax.net.ssl.SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  public SSLSocketFactory(String algorithm, KeyStore keystore, String keyPassword, KeyStore truststore, SecureRandom random, HostNameResolver nameResolver)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    this(SSLContexts.custom().useProtocol(algorithm).setSecureRandom(random).loadKeyMaterial(keystore, keyPassword != null ? keyPassword.toCharArray() : null).loadTrustMaterial(truststore).build(), nameResolver);
  }
  
  public SSLSocketFactory(String algorithm, KeyStore keystore, String keyPassword, KeyStore truststore, SecureRandom random, TrustStrategy trustStrategy, X509HostnameVerifier hostnameVerifier)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    this(SSLContexts.custom().useProtocol(algorithm).setSecureRandom(random).loadKeyMaterial(keystore, keyPassword != null ? keyPassword.toCharArray() : null).loadTrustMaterial(truststore, trustStrategy).build(), hostnameVerifier);
  }
  
  public SSLSocketFactory(String algorithm, KeyStore keystore, String keyPassword, KeyStore truststore, SecureRandom random, X509HostnameVerifier hostnameVerifier)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    this(SSLContexts.custom().useProtocol(algorithm).setSecureRandom(random).loadKeyMaterial(keystore, keyPassword != null ? keyPassword.toCharArray() : null).loadTrustMaterial(truststore).build(), hostnameVerifier);
  }
  
  public SSLSocketFactory(KeyStore keystore, String keystorePassword, KeyStore truststore)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    this(SSLContexts.custom().loadKeyMaterial(keystore, keystorePassword != null ? keystorePassword.toCharArray() : null).loadTrustMaterial(truststore).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  public SSLSocketFactory(KeyStore keystore, String keystorePassword)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    this(SSLContexts.custom().loadKeyMaterial(keystore, keystorePassword != null ? keystorePassword.toCharArray() : null).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  public SSLSocketFactory(KeyStore truststore)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    this(SSLContexts.custom().loadTrustMaterial(truststore).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  public SSLSocketFactory(TrustStrategy trustStrategy, X509HostnameVerifier hostnameVerifier)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    this(SSLContexts.custom().loadTrustMaterial(null, trustStrategy).build(), hostnameVerifier);
  }
  
  public SSLSocketFactory(TrustStrategy trustStrategy)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    this(SSLContexts.custom().loadTrustMaterial(null, trustStrategy).build(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  public SSLSocketFactory(SSLContext sslContext)
  {
    this(sslContext, BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  public SSLSocketFactory(SSLContext sslContext, HostNameResolver nameResolver)
  {
    socketfactory = sslContext.getSocketFactory();
    hostnameVerifier = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    this.nameResolver = nameResolver;
    supportedProtocols = null;
    supportedCipherSuites = null;
  }
  
  public SSLSocketFactory(SSLContext sslContext, X509HostnameVerifier hostnameVerifier)
  {
    this(((SSLContext)Args.notNull(sslContext, "SSL context")).getSocketFactory(), null, null, hostnameVerifier);
  }
  
  public SSLSocketFactory(SSLContext sslContext, String[] supportedProtocols, String[] supportedCipherSuites, X509HostnameVerifier hostnameVerifier)
  {
    this(((SSLContext)Args.notNull(sslContext, "SSL context")).getSocketFactory(), supportedProtocols, supportedCipherSuites, hostnameVerifier);
  }
  
  public SSLSocketFactory(javax.net.ssl.SSLSocketFactory socketfactory, X509HostnameVerifier hostnameVerifier)
  {
    this(socketfactory, null, null, hostnameVerifier);
  }
  
  public SSLSocketFactory(javax.net.ssl.SSLSocketFactory socketfactory, String[] supportedProtocols, String[] supportedCipherSuites, X509HostnameVerifier hostnameVerifier)
  {
    this.socketfactory = ((javax.net.ssl.SSLSocketFactory)Args.notNull(socketfactory, "SSL socket factory"));
    this.supportedProtocols = supportedProtocols;
    this.supportedCipherSuites = supportedCipherSuites;
    this.hostnameVerifier = (hostnameVerifier != null ? hostnameVerifier : BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    nameResolver = null;
  }
  
  public Socket createSocket(HttpParams params)
    throws IOException
  {
    return createSocket((HttpContext)null);
  }
  
  public Socket createSocket()
    throws IOException
  {
    return createSocket((HttpContext)null);
  }
  
  public Socket connectSocket(Socket socket, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpParams params)
    throws IOException, UnknownHostException, ConnectTimeoutException
  {
    Args.notNull(remoteAddress, "Remote address");
    Args.notNull(params, "HTTP parameters");
    HttpHost host;
    HttpHost host;
    if ((remoteAddress instanceof HttpInetSocketAddress)) {
      host = ((HttpInetSocketAddress)remoteAddress).getHttpHost();
    } else {
      host = new HttpHost(remoteAddress.getHostName(), remoteAddress.getPort(), "https");
    }
    int socketTimeout = HttpConnectionParams.getSoTimeout(params);
    int connectTimeout = HttpConnectionParams.getConnectionTimeout(params);
    socket.setSoTimeout(socketTimeout);
    return connectSocket(connectTimeout, socket, host, remoteAddress, localAddress, null);
  }
  
  public boolean isSecure(Socket sock)
    throws IllegalArgumentException
  {
    Args.notNull(sock, "Socket");
    Asserts.check(sock instanceof SSLSocket, "Socket not created by this factory");
    Asserts.check(!sock.isClosed(), "Socket is closed");
    return true;
  }
  
  public Socket createLayeredSocket(Socket socket, String host, int port, HttpParams params)
    throws IOException, UnknownHostException
  {
    return createLayeredSocket(socket, host, port, (HttpContext)null);
  }
  
  public Socket createLayeredSocket(Socket socket, String host, int port, boolean autoClose)
    throws IOException, UnknownHostException
  {
    return createLayeredSocket(socket, host, port, (HttpContext)null);
  }
  
  public void setHostnameVerifier(X509HostnameVerifier hostnameVerifier)
  {
    Args.notNull(hostnameVerifier, "Hostname verifier");
    this.hostnameVerifier = hostnameVerifier;
  }
  
  public X509HostnameVerifier getHostnameVerifier()
  {
    return hostnameVerifier;
  }
  
  public Socket connectSocket(Socket socket, String host, int port, InetAddress local, int localPort, HttpParams params)
    throws IOException, UnknownHostException, ConnectTimeoutException
  {
    InetAddress remote;
    InetAddress remote;
    if (nameResolver != null) {
      remote = nameResolver.resolve(host);
    } else {
      remote = InetAddress.getByName(host);
    }
    InetSocketAddress localAddress = null;
    if ((local != null) || (localPort > 0)) {
      localAddress = new InetSocketAddress(local, localPort > 0 ? localPort : 0);
    }
    InetSocketAddress remoteAddress = new HttpInetSocketAddress(new HttpHost(host, port), remote, port);
    
    return connectSocket(socket, remoteAddress, localAddress, params);
  }
  
  public Socket createSocket(Socket socket, String host, int port, boolean autoClose)
    throws IOException, UnknownHostException
  {
    return createLayeredSocket(socket, host, port, autoClose);
  }
  
  protected void prepareSocket(SSLSocket socket)
    throws IOException
  {}
  
  private void internalPrepareSocket(SSLSocket socket)
    throws IOException
  {
    if (supportedProtocols != null) {
      socket.setEnabledProtocols(supportedProtocols);
    }
    if (supportedCipherSuites != null) {
      socket.setEnabledCipherSuites(supportedCipherSuites);
    }
    prepareSocket(socket);
  }
  
  public Socket createSocket(HttpContext context)
    throws IOException
  {
    return SocketFactory.getDefault().createSocket();
  }
  
  public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpContext context)
    throws IOException
  {
    Args.notNull(host, "HTTP host");
    Args.notNull(remoteAddress, "Remote address");
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
    if ((sock instanceof SSLSocket))
    {
      SSLSocket sslsock = (SSLSocket)sock;
      sslsock.startHandshake();
      verifyHostname(sslsock, host.getHostName());
      return sock;
    }
    return createLayeredSocket(sock, host.getHostName(), remoteAddress.getPort(), context);
  }
  
  public Socket createLayeredSocket(Socket socket, String target, int port, HttpContext context)
    throws IOException
  {
    SSLSocket sslsock = (SSLSocket)socketfactory.createSocket(socket, target, port, true);
    
    internalPrepareSocket(sslsock);
    sslsock.startHandshake();
    verifyHostname(sslsock, target);
    return sslsock;
  }
  
  private void verifyHostname(SSLSocket sslsock, String hostname)
    throws IOException
  {
    try
    {
      hostnameVerifier.verify(hostname, sslsock);
    }
    catch (IOException iox)
    {
      try
      {
        sslsock.close();
      }
      catch (Exception x) {}
      throw iox;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.SSLSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
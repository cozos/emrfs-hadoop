package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ApacheHttpClientConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SDKGlobalConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.DelegatingDnsResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.SystemPropertyTlsKeyManagersProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.TlsKeyManagersProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.client.ConnectionManagerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.SdkPlainSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl.SdkTLSSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.settings.HttpClientSettings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkSSLContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.ConnectionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.ConnectionConfig.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.Registry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.RegistryBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.SocketConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.SocketConfig.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.ConnectionSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.DefaultSchemePortResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ApacheConnectionManagerFactory
  implements ConnectionManagerFactory<HttpClientConnectionManager>
{
  private final Log LOG = LogFactory.getLog(AmazonHttpClient.class);
  
  public HttpClientConnectionManager create(HttpClientSettings settings)
  {
    ConnectionSocketFactory sslsf = getPreferredSocketFactory(settings);
    
    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(createSocketFactoryRegistry(sslsf), null, DefaultSchemePortResolver.INSTANCE, new DelegatingDnsResolver(settings.getDnsResolver()), settings.getConnectionPoolTTL(), TimeUnit.MILLISECONDS);
    
    cm.setValidateAfterInactivity(settings.getValidateAfterInactivityMillis());
    cm.setDefaultMaxPerRoute(settings.getMaxConnections());
    cm.setMaxTotal(settings.getMaxConnections());
    cm.setDefaultSocketConfig(buildSocketConfig(settings));
    cm.setDefaultConnectionConfig(buildConnectionConfig(settings));
    
    return cm;
  }
  
  private ConnectionSocketFactory getPreferredSocketFactory(HttpClientSettings settings)
  {
    ConnectionSocketFactory sslsf = settings.getApacheHttpClientConfig().getSslSocketFactory();
    
    return sslsf != null ? sslsf : new SdkTLSSocketFactory(
    
      SdkSSLContext.getPreferredSSLContext(getKeyManagers(settings), settings.getSecureRandom()), 
      getHostNameVerifier(settings));
  }
  
  private SocketConfig buildSocketConfig(HttpClientSettings settings)
  {
    return 
    
      SocketConfig.custom().setSoKeepAlive(settings.useTcpKeepAlive()).setSoTimeout(settings.getSocketTimeout()).setTcpNoDelay(true).build();
  }
  
  private ConnectionConfig buildConnectionConfig(HttpClientSettings settings)
  {
    int socketBufferSize = Math.max(settings.getSocketBufferSize()[0], settings
      .getSocketBufferSize()[1]);
    
    return socketBufferSize <= 0 ? null : 
    
      ConnectionConfig.custom()
      .setBufferSize(socketBufferSize)
      .build();
  }
  
  private KeyManager[] getKeyManagers(HttpClientSettings settings)
  {
    TlsKeyManagersProvider provider = settings.getTlsKeyMangersProvider();
    if (provider == null) {
      provider = new SystemPropertyTlsKeyManagersProvider();
    }
    return provider.getKeyManagers();
  }
  
  private HostnameVerifier getHostNameVerifier(HttpClientSettings options)
  {
    return options.useBrowserCompatibleHostNameVerifier() ? SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER : SSLConnectionSocketFactory.STRICT_HOSTNAME_VERIFIER;
  }
  
  private Registry<ConnectionSocketFactory> createSocketFactoryRegistry(ConnectionSocketFactory sslSocketFactory)
  {
    if (SDKGlobalConfiguration.isCertCheckingDisabled())
    {
      if (LOG.isWarnEnabled()) {
        LOG.warn("SSL Certificate checking for endpoints has been explicitly disabled.");
      }
      sslSocketFactory = new TrustingSocketFactory(null);
    }
    return 
    
      RegistryBuilder.create().register("http", new SdkPlainSocketFactory()).register("https", sslSocketFactory).build();
  }
  
  private static class TrustingSocketFactory
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
  
  private static class TrustingX509TrustManager
    implements X509TrustManager
  {
    private static final X509Certificate[] X509_CERTIFICATES = new X509Certificate[0];
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return X509_CERTIFICATES;
    }
    
    public void checkServerTrusted(X509Certificate[] chain, String authType)
      throws CertificateException
    {}
    
    public void checkClientTrusted(X509Certificate[] chain, String authType)
      throws CertificateException
    {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl.ApacheConnectionManagerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
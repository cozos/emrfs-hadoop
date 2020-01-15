package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.IdleConnectionReaper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.SdkProxyRoutePlanner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.utils.ApacheUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.client.ConnectionManagerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.client.HttpClientFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ClientConnectionManagerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.SdkConnectionKeepAliveStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.protocol.SdkHttpRequestExecutor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.settings.HttpClientSettings;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionKeepAliveStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.HttpClientBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.HttpClients;

public class ApacheHttpClientFactory
  implements HttpClientFactory<ConnectionManagerAwareHttpClient>
{
  private static final Log LOG = LogFactory.getLog(AmazonHttpClient.class);
  private final ConnectionManagerFactory<HttpClientConnectionManager> cmFactory = new ApacheConnectionManagerFactory();
  
  public ConnectionManagerAwareHttpClient create(HttpClientSettings settings)
  {
    HttpClientBuilder builder = HttpClients.custom();
    
    HttpClientConnectionManager cm = (HttpClientConnectionManager)cmFactory.create(settings);
    
    builder.setRequestExecutor(new SdkHttpRequestExecutor())
      .setKeepAliveStrategy(buildKeepAliveStrategy(settings))
      .disableRedirectHandling()
      .disableAutomaticRetries()
      .setConnectionManager(ClientConnectionManagerFactory.wrap(cm));
    if (!settings.useGzip()) {
      builder.disableContentCompression();
    }
    HttpResponseInterceptor itcp = new CRC32ChecksumResponseInterceptor();
    if (settings.calculateCRC32FromCompressedData()) {
      builder.addInterceptorFirst(itcp);
    } else {
      builder.addInterceptorLast(itcp);
    }
    addProxyConfig(builder, settings);
    
    ConnectionManagerAwareHttpClient httpClient = new SdkHttpClient(builder.build(), cm);
    if (settings.useReaper()) {
      IdleConnectionReaper.registerConnectionManager(cm, settings.getMaxIdleConnectionTime());
    }
    return httpClient;
  }
  
  private void addProxyConfig(HttpClientBuilder builder, HttpClientSettings settings)
  {
    if (settings.isProxyEnabled())
    {
      LOG.info("Configuring Proxy. Proxy Host: " + settings.getProxyHost() + " Proxy Port: " + settings
        .getProxyPort());
      
      builder.setRoutePlanner(new SdkProxyRoutePlanner(settings
        .getProxyHost(), settings.getProxyPort(), settings.getProxyProtocol(), settings.getNonProxyHosts()));
      if (settings.isAuthenticatedProxy()) {
        builder.setDefaultCredentialsProvider(ApacheUtils.newProxyCredentialsProvider(settings));
      }
    }
  }
  
  private ConnectionKeepAliveStrategy buildKeepAliveStrategy(HttpClientSettings settings)
  {
    return settings.getMaxIdleConnectionTime() > 0L ? new SdkConnectionKeepAliveStrategy(settings
      .getMaxIdleConnectionTime()) : null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl.ApacheHttpClientFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.settings;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ApacheHttpClientConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DnsResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Protocol;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ProxyAuthenticationMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.TlsKeyManagersProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.List;

@SdkInternalApi
public class HttpClientSettings
{
  private final ClientConfiguration config;
  private final boolean useBrowserCompatibleHostNameVerifier;
  private final boolean calculateCRC32FromCompressedData;
  
  HttpClientSettings(ClientConfiguration config, boolean useBrowserCompatibleHostNameVerifier, boolean calculateCRC32FromCompressedData)
  {
    this.config = ((ClientConfiguration)ValidationUtils.assertNotNull(config, "client configuration"));
    this.useBrowserCompatibleHostNameVerifier = useBrowserCompatibleHostNameVerifier;
    this.calculateCRC32FromCompressedData = calculateCRC32FromCompressedData;
  }
  
  public static HttpClientSettings adapt(ClientConfiguration config, boolean useBrowserCompatibleHostNameVerifier, boolean calculateCRC32FromCompressedData)
  {
    return new HttpClientSettings(config, useBrowserCompatibleHostNameVerifier, calculateCRC32FromCompressedData);
  }
  
  public static HttpClientSettings adapt(ClientConfiguration config, boolean useBrowserCompatibleHostNameVerifier)
  {
    return adapt(config, useBrowserCompatibleHostNameVerifier, false);
  }
  
  public static HttpClientSettings adapt(ClientConfiguration config)
  {
    return adapt(config, false);
  }
  
  public boolean useBrowserCompatibleHostNameVerifier()
  {
    return useBrowserCompatibleHostNameVerifier;
  }
  
  public boolean calculateCRC32FromCompressedData()
  {
    return calculateCRC32FromCompressedData;
  }
  
  public int getMaxConnections()
  {
    return config.getMaxConnections();
  }
  
  public InetAddress getLocalAddress()
  {
    return config.getLocalAddress();
  }
  
  public String getProxyHost()
  {
    return config.getProxyHost();
  }
  
  public int getProxyPort()
  {
    return config.getProxyPort();
  }
  
  public String getProxyUsername()
  {
    return config.getProxyUsername();
  }
  
  public String getProxyPassword()
  {
    return config.getProxyPassword();
  }
  
  public String getNonProxyHosts()
  {
    return config.getNonProxyHosts();
  }
  
  public List<ProxyAuthenticationMethod> getProxyAuthenticationMethods()
  {
    return config.getProxyAuthenticationMethods();
  }
  
  public boolean useReaper()
  {
    return config.useReaper();
  }
  
  public boolean useGzip()
  {
    return config.useGzip();
  }
  
  public DnsResolver getDnsResolver()
  {
    return config.getDnsResolver();
  }
  
  public ApacheHttpClientConfig getApacheHttpClientConfig()
  {
    return config.getApacheHttpClientConfig();
  }
  
  public int getSocketTimeout()
  {
    return config.getSocketTimeout();
  }
  
  public int[] getSocketBufferSize()
  {
    return config.getSocketBufferSizeHints();
  }
  
  public boolean useTcpKeepAlive()
  {
    return config.useTcpKeepAlive();
  }
  
  public SecureRandom getSecureRandom()
  {
    return config.getSecureRandom();
  }
  
  public int getConnectionTimeout()
  {
    return config.getConnectionTimeout();
  }
  
  public int getConnectionPoolRequestTimeout()
  {
    return config.getConnectionTimeout();
  }
  
  public long getConnectionPoolTTL()
  {
    return config.getConnectionTTL();
  }
  
  public long getMaxIdleConnectionTime()
  {
    return config.getConnectionMaxIdleMillis();
  }
  
  public int getValidateAfterInactivityMillis()
  {
    return config.getValidateAfterInactivityMillis();
  }
  
  public String getProxyWorkstation()
  {
    return config.getProxyWorkstation();
  }
  
  public String getProxyDomain()
  {
    return config.getProxyDomain();
  }
  
  public boolean isPreemptiveBasicProxyAuth()
  {
    return config.isPreemptiveBasicProxyAuth();
  }
  
  public boolean isUseExpectContinue()
  {
    return config.isUseExpectContinue();
  }
  
  public boolean isProxyEnabled()
  {
    return (getProxyHost() != null) && (getProxyPort() > 0);
  }
  
  public boolean disableSocketProxy()
  {
    return config.disableSocketProxy();
  }
  
  public boolean isAuthenticatedProxy()
  {
    return (getProxyUsername() != null) && (getProxyPassword() != null);
  }
  
  public Protocol getProxyProtocol()
  {
    return config.getProxyProtocol();
  }
  
  public TlsKeyManagersProvider getTlsKeyMangersProvider()
  {
    return config.getTlsKeyManagersProvider();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.settings.HttpClientSettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import java.net.InetAddress;
import java.util.Collection;

public class RequestConfig$Builder
{
  private boolean expectContinueEnabled;
  private HttpHost proxy;
  private InetAddress localAddress;
  private boolean staleConnectionCheckEnabled;
  private String cookieSpec;
  private boolean redirectsEnabled;
  private boolean relativeRedirectsAllowed;
  private boolean circularRedirectsAllowed;
  private int maxRedirects;
  private boolean authenticationEnabled;
  private Collection<String> targetPreferredAuthSchemes;
  private Collection<String> proxyPreferredAuthSchemes;
  private int connectionRequestTimeout;
  private int connectTimeout;
  private int socketTimeout;
  private boolean contentCompressionEnabled;
  
  RequestConfig$Builder()
  {
    staleConnectionCheckEnabled = false;
    redirectsEnabled = true;
    maxRedirects = 50;
    relativeRedirectsAllowed = true;
    authenticationEnabled = true;
    connectionRequestTimeout = -1;
    connectTimeout = -1;
    socketTimeout = -1;
    contentCompressionEnabled = true;
  }
  
  public Builder setExpectContinueEnabled(boolean expectContinueEnabled)
  {
    this.expectContinueEnabled = expectContinueEnabled;
    return this;
  }
  
  public Builder setProxy(HttpHost proxy)
  {
    this.proxy = proxy;
    return this;
  }
  
  public Builder setLocalAddress(InetAddress localAddress)
  {
    this.localAddress = localAddress;
    return this;
  }
  
  @Deprecated
  public Builder setStaleConnectionCheckEnabled(boolean staleConnectionCheckEnabled)
  {
    this.staleConnectionCheckEnabled = staleConnectionCheckEnabled;
    return this;
  }
  
  public Builder setCookieSpec(String cookieSpec)
  {
    this.cookieSpec = cookieSpec;
    return this;
  }
  
  public Builder setRedirectsEnabled(boolean redirectsEnabled)
  {
    this.redirectsEnabled = redirectsEnabled;
    return this;
  }
  
  public Builder setRelativeRedirectsAllowed(boolean relativeRedirectsAllowed)
  {
    this.relativeRedirectsAllowed = relativeRedirectsAllowed;
    return this;
  }
  
  public Builder setCircularRedirectsAllowed(boolean circularRedirectsAllowed)
  {
    this.circularRedirectsAllowed = circularRedirectsAllowed;
    return this;
  }
  
  public Builder setMaxRedirects(int maxRedirects)
  {
    this.maxRedirects = maxRedirects;
    return this;
  }
  
  public Builder setAuthenticationEnabled(boolean authenticationEnabled)
  {
    this.authenticationEnabled = authenticationEnabled;
    return this;
  }
  
  public Builder setTargetPreferredAuthSchemes(Collection<String> targetPreferredAuthSchemes)
  {
    this.targetPreferredAuthSchemes = targetPreferredAuthSchemes;
    return this;
  }
  
  public Builder setProxyPreferredAuthSchemes(Collection<String> proxyPreferredAuthSchemes)
  {
    this.proxyPreferredAuthSchemes = proxyPreferredAuthSchemes;
    return this;
  }
  
  public Builder setConnectionRequestTimeout(int connectionRequestTimeout)
  {
    this.connectionRequestTimeout = connectionRequestTimeout;
    return this;
  }
  
  public Builder setConnectTimeout(int connectTimeout)
  {
    this.connectTimeout = connectTimeout;
    return this;
  }
  
  public Builder setSocketTimeout(int socketTimeout)
  {
    this.socketTimeout = socketTimeout;
    return this;
  }
  
  @Deprecated
  public Builder setDecompressionEnabled(boolean decompressionEnabled)
  {
    contentCompressionEnabled = decompressionEnabled;
    return this;
  }
  
  public Builder setContentCompressionEnabled(boolean contentCompressionEnabled)
  {
    this.contentCompressionEnabled = contentCompressionEnabled;
    return this;
  }
  
  public RequestConfig build()
  {
    return new RequestConfig(expectContinueEnabled, proxy, localAddress, staleConnectionCheckEnabled, cookieSpec, redirectsEnabled, relativeRedirectsAllowed, circularRedirectsAllowed, maxRedirects, authenticationEnabled, targetPreferredAuthSchemes, proxyPreferredAuthSchemes, connectionRequestTimeout, connectTimeout, socketTimeout, contentCompressionEnabled);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
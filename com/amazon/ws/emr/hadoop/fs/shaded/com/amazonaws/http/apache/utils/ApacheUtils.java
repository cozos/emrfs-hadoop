package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.utils;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.settings.HttpClientSettings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.FakeIOException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ReflectionMethodInvoker;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScope;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.NTCredentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.AuthCache;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.BufferedHttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.StringEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.BasicScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.BasicAuthCache;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.BasicCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

public class ApacheUtils
{
  private static final Log log = LogFactory.getLog(ApacheUtils.class);
  private static final ReflectionMethodInvoker<RequestConfig.Builder, RequestConfig.Builder> normalizeUriInvoker = new ReflectionMethodInvoker(RequestConfig.Builder.class, RequestConfig.Builder.class, "setNormalizeUri", new Class[] { Boolean.TYPE });
  
  static
  {
    try
    {
      normalizeUriInvoker.initialize();
    }
    catch (NoSuchMethodException ignored)
    {
      noSuchMethodThrownByNormalizeUriInvoker();
    }
  }
  
  private final boolean normalizeUriMethodNotFound = false;
  
  public static boolean isRequestSuccessful(com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse response)
  {
    int status = response.getStatusLine().getStatusCode();
    return status / 100 == 2;
  }
  
  public static com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse createResponse(Request<?> request, HttpRequestBase method, com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse apacheHttpResponse, HttpContext context)
    throws IOException
  {
    com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse httpResponse = new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse(request, method, context);
    if (apacheHttpResponse.getEntity() != null) {
      httpResponse.setContent(apacheHttpResponse.getEntity().getContent());
    }
    httpResponse.setStatusCode(apacheHttpResponse.getStatusLine().getStatusCode());
    httpResponse.setStatusText(apacheHttpResponse.getStatusLine().getReasonPhrase());
    for (Header header : apacheHttpResponse.getAllHeaders()) {
      httpResponse.addHeader(header.getName(), header.getValue());
    }
    return httpResponse;
  }
  
  public static HttpEntity newStringEntity(String s)
  {
    try
    {
      return new StringEntity(s);
    }
    catch (UnsupportedEncodingException e)
    {
      throw new SdkClientException("Unable to create HTTP entity: " + e.getMessage(), e);
    }
  }
  
  public static HttpEntity newBufferedHttpEntity(HttpEntity entity)
    throws FakeIOException
  {
    try
    {
      return new BufferedHttpEntity(entity);
    }
    catch (FakeIOException e)
    {
      throw e;
    }
    catch (IOException e)
    {
      throw new SdkClientException("Unable to create HTTP entity: " + e.getMessage(), e);
    }
  }
  
  public static HttpClientContext newClientContext(HttpClientSettings settings, Map<String, ? extends Object> attributes)
  {
    HttpClientContext clientContext = new HttpClientContext();
    if ((attributes != null) && (!attributes.isEmpty())) {
      for (Map.Entry<String, ?> entry : attributes.entrySet()) {
        clientContext.setAttribute((String)entry.getKey(), entry.getValue());
      }
    }
    addPreemptiveAuthenticationProxy(clientContext, settings);
    
    RequestConfig.Builder builder = RequestConfig.custom();
    disableNormalizeUri(builder);
    
    clientContext.setRequestConfig(builder.build());
    clientContext.setAttribute("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.disableSocketProxy", Boolean.valueOf(settings.disableSocketProxy()));
    return clientContext;
  }
  
  public static void disableNormalizeUri(RequestConfig.Builder requestConfigBuilder)
  {
    if (normalizeUriInvoker.isInitialized()) {
      try
      {
        normalizeUriInvoker.invoke(requestConfigBuilder, new Object[] { Boolean.valueOf(false) });
      }
      catch (NoSuchMethodException ignored)
      {
        noSuchMethodThrownByNormalizeUriInvoker();
      }
    }
  }
  
  public static CredentialsProvider newProxyCredentialsProvider(HttpClientSettings settings)
  {
    CredentialsProvider provider = new BasicCredentialsProvider();
    provider.setCredentials(newAuthScope(settings), newNTCredentials(settings));
    return provider;
  }
  
  private static Credentials newNTCredentials(HttpClientSettings settings)
  {
    return new NTCredentials(settings.getProxyUsername(), settings
      .getProxyPassword(), settings
      .getProxyWorkstation(), settings
      .getProxyDomain());
  }
  
  private static AuthScope newAuthScope(HttpClientSettings settings)
  {
    return new AuthScope(settings.getProxyHost(), settings.getProxyPort());
  }
  
  private static void addPreemptiveAuthenticationProxy(HttpClientContext clientContext, HttpClientSettings settings)
  {
    if (settings.isPreemptiveBasicProxyAuth())
    {
      HttpHost targetHost = new HttpHost(settings.getProxyHost(), settings.getProxyPort());
      CredentialsProvider credsProvider = newProxyCredentialsProvider(settings);
      
      AuthCache authCache = new BasicAuthCache();
      
      BasicScheme basicAuth = new BasicScheme();
      authCache.put(targetHost, basicAuth);
      
      clientContext.setCredentialsProvider(credsProvider);
      clientContext.setAuthCache(authCache);
    }
  }
  
  private static void noSuchMethodThrownByNormalizeUriInvoker()
  {
    log.warn("NoSuchMethodException was thrown when disabling normalizeUri. This indicates you are using an old version (< 4.5.8) of Apache http client. It is recommended to use http client version >= 4.5.9 to avoid the breaking change introduced in apache client 4.5.7 and the latency in exception handling. See https://github.com/aws/aws-sdk-java/issues/1919 for more information");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.utils.ApacheUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
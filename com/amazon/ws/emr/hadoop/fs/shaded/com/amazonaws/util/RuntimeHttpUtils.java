package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Protocol;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScope;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.NTCredentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpGet;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.BasicHttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpConnectionParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpProtocolParams;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RuntimeHttpUtils
{
  private static final String COMMA = ", ";
  private static final String SPACE = " ";
  private static final String AWS_EXECUTION_ENV_PREFIX = "exec-env/";
  private static final String AWS_EXECUTION_ENV_NAME = "AWS_EXECUTION_ENV";
  
  public static InputStream fetchFile(URI uri, ClientConfiguration config)
    throws IOException
  {
    HttpParams httpClientParams = new BasicHttpParams();
    HttpProtocolParams.setUserAgent(httpClientParams, 
      getUserAgent(config, null));
    
    HttpConnectionParams.setConnectionTimeout(httpClientParams, 
      getConnectionTimeout(config));
    HttpConnectionParams.setSoTimeout(httpClientParams, 
      getSocketTimeout(config));
    
    DefaultHttpClient httpclient = new DefaultHttpClient(httpClientParams);
    if (config != null)
    {
      String proxyHost = config.getProxyHost();
      int proxyPort = config.getProxyPort();
      if ((proxyHost != null) && (proxyPort > 0))
      {
        HttpHost proxy = new HttpHost(proxyHost, proxyPort);
        httpclient.getParams().setParameter("http.route.default-proxy", proxy);
        if ((config.getProxyUsername() != null) && 
          (config.getProxyPassword() != null)) {
          httpclient.getCredentialsProvider().setCredentials(new AuthScope(proxyHost, proxyPort), new NTCredentials(config
          
            .getProxyUsername(), config
            .getProxyPassword(), config
            .getProxyWorkstation(), config
            .getProxyDomain()));
        }
      }
    }
    HttpResponse response = httpclient.execute(new HttpGet(uri));
    if (response.getStatusLine().getStatusCode() != 200) {
      throw new IOException("Error fetching file from " + uri + ": " + response);
    }
    return new HttpClientWrappingInputStream(httpclient, response
    
      .getEntity().getContent());
  }
  
  public static String getUserAgent(ClientConfiguration config, String userAgentMarker)
  {
    String userDefinedPrefix = config != null ? config.getUserAgentPrefix() : "";
    String userDefinedSuffix = config != null ? config.getUserAgentSuffix() : "";
    String awsExecutionEnvironment = getEnvironmentVariable("AWS_EXECUTION_ENV");
    
    StringBuilder userAgent = new StringBuilder(userDefinedPrefix.trim());
    if (!ClientConfiguration.DEFAULT_USER_AGENT.equals(userDefinedPrefix)) {
      userAgent.append(", ").append(ClientConfiguration.DEFAULT_USER_AGENT);
    }
    if (StringUtils.hasValue(userDefinedSuffix)) {
      userAgent.append(", ").append(userDefinedSuffix.trim());
    }
    if (StringUtils.hasValue(awsExecutionEnvironment)) {
      userAgent.append(" ").append("exec-env/").append(awsExecutionEnvironment.trim());
    }
    if (StringUtils.hasValue(userAgentMarker)) {
      userAgent.append(" ").append(userAgentMarker.trim());
    }
    return userAgent.toString();
  }
  
  private static String getEnvironmentVariable(String environmentVariableName)
  {
    try
    {
      return System.getenv(environmentVariableName);
    }
    catch (Exception e) {}
    return "";
  }
  
  private static int getConnectionTimeout(ClientConfiguration config)
  {
    if (config != null) {
      return config.getConnectionTimeout();
    }
    return 10000;
  }
  
  private static int getSocketTimeout(ClientConfiguration config)
  {
    if (config != null) {
      return config.getSocketTimeout();
    }
    return 50000;
  }
  
  public static URI toUri(String endpoint, ClientConfiguration config)
  {
    if (config == null) {
      throw new IllegalArgumentException("ClientConfiguration cannot be null");
    }
    return toUri(endpoint, config.getProtocol());
  }
  
  public static URI toUri(String endpoint, Protocol protocol)
  {
    if (endpoint == null) {
      throw new IllegalArgumentException("endpoint cannot be null");
    }
    if (!endpoint.contains("://")) {
      endpoint = protocol.toString() + "://" + endpoint;
    }
    try
    {
      return new URI(endpoint);
    }
    catch (URISyntaxException e)
    {
      throw new IllegalArgumentException(e);
    }
  }
  
  @SdkProtectedApi
  public static URL convertRequestToUrl(Request<?> request, boolean removeLeadingSlashInResourcePath, boolean urlEncode)
  {
    String resourcePath = urlEncode ? SdkHttpUtils.urlEncode(request.getResourcePath(), true) : request.getResourcePath();
    if ((removeLeadingSlashInResourcePath) && 
      (resourcePath.startsWith("/"))) {
      resourcePath = resourcePath.substring(1);
    }
    String urlPath = "/" + resourcePath;
    urlPath = urlPath.replaceAll("(?<=/)/", "%2F");
    StringBuilder url = new StringBuilder(request.getEndpoint().toString());
    url.append(urlPath);
    
    StringBuilder queryParams = new StringBuilder();
    Map<String, List<String>> requestParams = request.getParameters();
    for (Iterator localIterator1 = requestParams.entrySet().iterator(); localIterator1.hasNext();)
    {
      entry = (Map.Entry)localIterator1.next();
      for (String value : (List)entry.getValue())
      {
        queryParams = queryParams.length() > 0 ? queryParams.append("&") : queryParams.append("?");
        queryParams.append(SdkHttpUtils.urlEncode((String)entry.getKey(), false))
          .append("=")
          .append(SdkHttpUtils.urlEncode(value, false));
      }
    }
    Map.Entry<String, List<String>> entry;
    url.append(queryParams.toString());
    try
    {
      return new URL(url.toString());
    }
    catch (MalformedURLException e)
    {
      throw new SdkClientException("Unable to convert request to well formed URL: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.RuntimeHttpUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
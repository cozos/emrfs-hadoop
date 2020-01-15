package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.request.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ProxyAuthenticationMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.RepeatableInputStreamRequestEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.utils.ApacheUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.request.HttpRequestFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.settings.HttpClientSettings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.FakeIOException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpDelete;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpHead;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpPatch;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpPost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpPut;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ApacheHttpRequestFactory
  implements HttpRequestFactory<HttpRequestBase>
{
  private static final String DEFAULT_ENCODING = "UTF-8";
  private static final List<String> ignoreHeaders = Arrays.asList(new String[] { "Content-Length", "Host" });
  
  public HttpRequestBase create(Request<?> request, HttpClientSettings settings)
    throws FakeIOException
  {
    URI endpoint = request.getEndpoint();
    String uri;
    String uri;
    if (request.getOriginalRequest().getRequestClientOptions().isSkipAppendUriPath()) {
      uri = endpoint.toString();
    } else {
      uri = SdkHttpUtils.appendUri(endpoint.toString(), request.getResourcePath(), true);
    }
    String encodedParams = SdkHttpUtils.encodeParameters(request);
    
    boolean requestHasNoPayload = request.getContent() != null;
    boolean requestIsPost = request.getHttpMethod() == HttpMethodName.POST;
    boolean putParamsInUri = (!requestIsPost) || (requestHasNoPayload);
    if ((encodedParams != null) && (putParamsInUri)) {
      uri = uri + "?" + encodedParams;
    }
    HttpRequestBase base = createApacheRequest(request, uri, encodedParams);
    addHeadersToRequest(base, request);
    addRequestConfig(base, request, settings);
    
    return base;
  }
  
  private void addRequestConfig(HttpRequestBase base, Request<?> request, HttpClientSettings settings)
  {
    RequestConfig.Builder requestConfigBuilder = RequestConfig.custom().setConnectionRequestTimeout(settings.getConnectionPoolRequestTimeout()).setConnectTimeout(settings.getConnectionTimeout()).setSocketTimeout(settings.getSocketTimeout()).setLocalAddress(settings.getLocalAddress());
    
    ApacheUtils.disableNormalizeUri(requestConfigBuilder);
    if ((HttpMethodName.PUT == request.getHttpMethod()) && (settings.isUseExpectContinue())) {
      requestConfigBuilder.setExpectContinueEnabled(true);
    }
    addProxyConfig(requestConfigBuilder, settings);
    
    base.setConfig(requestConfigBuilder.build());
  }
  
  private HttpRequestBase createApacheRequest(Request<?> request, String uri, String encodedParams)
    throws FakeIOException
  {
    switch (request.getHttpMethod())
    {
    case HEAD: 
      return new HttpHead(uri);
    case GET: 
      return wrapEntity(request, new HttpGetWithBody(uri), encodedParams);
    case DELETE: 
      return new HttpDelete(uri);
    case OPTIONS: 
      return new HttpOptions(uri);
    case PATCH: 
      return wrapEntity(request, new HttpPatch(uri), encodedParams);
    case POST: 
      return wrapEntity(request, new HttpPost(uri), encodedParams);
    case PUT: 
      return wrapEntity(request, new HttpPut(uri), encodedParams);
    }
    throw new SdkClientException("Unknown HTTP method name: " + request.getHttpMethod());
  }
  
  private HttpRequestBase wrapEntity(Request<?> request, HttpEntityEnclosingRequestBase entityEnclosingRequest, String encodedParams)
    throws FakeIOException
  {
    if (HttpMethodName.POST == request.getHttpMethod())
    {
      if ((request.getContent() == null) && (encodedParams != null)) {
        entityEnclosingRequest.setEntity(ApacheUtils.newStringEntity(encodedParams));
      } else {
        createHttpEntityForPostVerb(request, entityEnclosingRequest);
      }
    }
    else if (request.getContent() != null) {
      createHttpEntityForNonPostVerbs(request, entityEnclosingRequest);
    }
    return entityEnclosingRequest;
  }
  
  private void createHttpEntityForPostVerb(Request<?> request, HttpEntityEnclosingRequestBase entityEnclosingRequest)
    throws FakeIOException
  {
    HttpEntity entity = new RepeatableInputStreamRequestEntity(request);
    if ((request.getHeaders().get("Content-Length") == null) && (isRequiresLength(request))) {
      entity = ApacheUtils.newBufferedHttpEntity(entity);
    }
    entityEnclosingRequest.setEntity(entity);
  }
  
  private void createHttpEntityForNonPostVerbs(Request<?> request, HttpEntityEnclosingRequestBase entityEnclosingRequest)
    throws FakeIOException
  {
    HttpEntity entity = new RepeatableInputStreamRequestEntity(request);
    if ((request.getHeaders().get("Content-Length") == null) && (
      (isRequiresLength(request)) || (!hasStreamingInput(request)))) {
      entity = ApacheUtils.newBufferedHttpEntity(entity);
    }
    entityEnclosingRequest.setEntity(entity);
  }
  
  private boolean isRequiresLength(Request<?> request)
  {
    return Boolean.TRUE.equals(request.getHandlerContext(HandlerContextKey.REQUIRES_LENGTH));
  }
  
  private boolean hasStreamingInput(Request<?> request)
  {
    return Boolean.TRUE.equals(request.getHandlerContext(HandlerContextKey.HAS_STREAMING_INPUT));
  }
  
  private void addHeadersToRequest(HttpRequestBase httpRequest, Request<?> request)
  {
    httpRequest.addHeader("Host", getHostHeaderValue(request.getEndpoint()));
    for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
      if (!ignoreHeaders.contains(entry.getKey())) {
        httpRequest.addHeader((String)entry.getKey(), (String)entry.getValue());
      }
    }
    if ((httpRequest.getHeaders("Content-Type") == null) || 
    
      (httpRequest.getHeaders("Content-Type").length == 0)) {
      httpRequest.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + "UTF-8"
      
        .toLowerCase());
    }
  }
  
  private String getHostHeaderValue(URI endpoint)
  {
    return SdkHttpUtils.isUsingNonDefaultPort(endpoint) ? endpoint
      .getHost() + ":" + endpoint.getPort() : endpoint
      .getHost();
  }
  
  private void addProxyConfig(RequestConfig.Builder requestConfigBuilder, HttpClientSettings settings)
  {
    if ((settings.isProxyEnabled()) && (settings.isAuthenticatedProxy()) && (settings.getProxyAuthenticationMethods() != null))
    {
      List<String> apacheAuthenticationSchemes = new ArrayList();
      for (ProxyAuthenticationMethod authenticationMethod : settings.getProxyAuthenticationMethods()) {
        apacheAuthenticationSchemes.add(toApacheAuthenticationScheme(authenticationMethod));
      }
      requestConfigBuilder.setProxyPreferredAuthSchemes(apacheAuthenticationSchemes);
    }
  }
  
  private String toApacheAuthenticationScheme(ProxyAuthenticationMethod authenticationMethod)
  {
    if (authenticationMethod == null) {
      throw new IllegalStateException("The configured proxy authentication methods must not be null.");
    }
    switch (authenticationMethod)
    {
    case NTLM: 
      return "NTLM";
    case BASIC: 
      return "Basic";
    case DIGEST: 
      return "Digest";
    case SPNEGO: 
      return "Negotiate";
    case KERBEROS: 
      return "Kerberos";
    }
    throw new IllegalStateException("Unknown authentication scheme: " + authenticationMethod);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.request.impl.ApacheHttpRequestFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ClientProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.HttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpUriRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;

public class SdkHttpClient
  implements ConnectionManagerAwareHttpClient
{
  private final HttpClient delegate;
  private final HttpClientConnectionManager cm;
  
  public SdkHttpClient(HttpClient delegate, HttpClientConnectionManager cm)
  {
    if (delegate == null) {
      throw new IllegalArgumentException("delegate cannot be null");
    }
    if (cm == null) {
      throw new IllegalArgumentException("connection manager cannot be null");
    }
    this.delegate = delegate;
    this.cm = cm;
  }
  
  public HttpParams getParams()
  {
    return delegate.getParams();
  }
  
  public ClientConnectionManager getConnectionManager()
  {
    return delegate.getConnectionManager();
  }
  
  public HttpResponse execute(HttpUriRequest request)
    throws IOException, ClientProtocolException
  {
    return delegate.execute(request);
  }
  
  public HttpResponse execute(HttpUriRequest request, HttpContext context)
    throws IOException, ClientProtocolException
  {
    return delegate.execute(request, context);
  }
  
  public HttpResponse execute(HttpHost target, HttpRequest request)
    throws IOException, ClientProtocolException
  {
    return delegate.execute(target, request);
  }
  
  public HttpResponse execute(HttpHost target, HttpRequest request, HttpContext context)
    throws IOException, ClientProtocolException
  {
    return delegate.execute(target, request, context);
  }
  
  public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler)
    throws IOException, ClientProtocolException
  {
    return (T)delegate.execute(request, responseHandler);
  }
  
  public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context)
    throws IOException, ClientProtocolException
  {
    return (T)delegate.execute(request, responseHandler, context);
  }
  
  public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler)
    throws IOException, ClientProtocolException
  {
    return (T)delegate.execute(target, request, responseHandler);
  }
  
  public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context)
    throws IOException, ClientProtocolException
  {
    return (T)delegate.execute(target, request, responseHandler, context);
  }
  
  public HttpClientConnectionManager getHttpClientConnectionManager()
  {
    return cm;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.client.impl.SdkHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
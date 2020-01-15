package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;

public class HttpProcessorBuilder
{
  private ChainBuilder<HttpRequestInterceptor> requestChainBuilder;
  private ChainBuilder<HttpResponseInterceptor> responseChainBuilder;
  
  public static HttpProcessorBuilder create()
  {
    return new HttpProcessorBuilder();
  }
  
  private ChainBuilder<HttpRequestInterceptor> getRequestChainBuilder()
  {
    if (requestChainBuilder == null) {
      requestChainBuilder = new ChainBuilder();
    }
    return requestChainBuilder;
  }
  
  private ChainBuilder<HttpResponseInterceptor> getResponseChainBuilder()
  {
    if (responseChainBuilder == null) {
      responseChainBuilder = new ChainBuilder();
    }
    return responseChainBuilder;
  }
  
  public HttpProcessorBuilder addFirst(HttpRequestInterceptor e)
  {
    if (e == null) {
      return this;
    }
    getRequestChainBuilder().addFirst(e);
    return this;
  }
  
  public HttpProcessorBuilder addLast(HttpRequestInterceptor e)
  {
    if (e == null) {
      return this;
    }
    getRequestChainBuilder().addLast(e);
    return this;
  }
  
  public HttpProcessorBuilder add(HttpRequestInterceptor e)
  {
    return addLast(e);
  }
  
  public HttpProcessorBuilder addAllFirst(HttpRequestInterceptor... e)
  {
    if (e == null) {
      return this;
    }
    getRequestChainBuilder().addAllFirst(e);
    return this;
  }
  
  public HttpProcessorBuilder addAllLast(HttpRequestInterceptor... e)
  {
    if (e == null) {
      return this;
    }
    getRequestChainBuilder().addAllLast(e);
    return this;
  }
  
  public HttpProcessorBuilder addAll(HttpRequestInterceptor... e)
  {
    return addAllLast(e);
  }
  
  public HttpProcessorBuilder addFirst(HttpResponseInterceptor e)
  {
    if (e == null) {
      return this;
    }
    getResponseChainBuilder().addFirst(e);
    return this;
  }
  
  public HttpProcessorBuilder addLast(HttpResponseInterceptor e)
  {
    if (e == null) {
      return this;
    }
    getResponseChainBuilder().addLast(e);
    return this;
  }
  
  public HttpProcessorBuilder add(HttpResponseInterceptor e)
  {
    return addLast(e);
  }
  
  public HttpProcessorBuilder addAllFirst(HttpResponseInterceptor... e)
  {
    if (e == null) {
      return this;
    }
    getResponseChainBuilder().addAllFirst(e);
    return this;
  }
  
  public HttpProcessorBuilder addAllLast(HttpResponseInterceptor... e)
  {
    if (e == null) {
      return this;
    }
    getResponseChainBuilder().addAllLast(e);
    return this;
  }
  
  public HttpProcessorBuilder addAll(HttpResponseInterceptor... e)
  {
    return addAllLast(e);
  }
  
  public HttpProcessor build()
  {
    return new ImmutableHttpProcessor(requestChainBuilder != null ? requestChainBuilder.build() : null, responseChainBuilder != null ? responseChainBuilder.build() : null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpProcessorBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
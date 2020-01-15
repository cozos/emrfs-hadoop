package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;

@Deprecated
class HttpService$HttpRequestHandlerResolverAdapter
  implements HttpRequestHandlerMapper
{
  private final HttpRequestHandlerResolver resolver;
  
  public HttpService$HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver resolver)
  {
    this.resolver = resolver;
  }
  
  public HttpRequestHandler lookup(HttpRequest request)
  {
    return resolver.lookup(request.getRequestLine().getUri());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpService.HttpRequestHandlerResolverAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
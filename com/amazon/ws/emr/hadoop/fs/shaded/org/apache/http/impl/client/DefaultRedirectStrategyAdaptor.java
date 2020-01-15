package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.RedirectHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.RedirectStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpGet;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpHead;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpUriRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.net.URI;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
class DefaultRedirectStrategyAdaptor
  implements RedirectStrategy
{
  private final RedirectHandler handler;
  
  public DefaultRedirectStrategyAdaptor(RedirectHandler handler)
  {
    this.handler = handler;
  }
  
  public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context)
    throws ProtocolException
  {
    return handler.isRedirectRequested(response, context);
  }
  
  public HttpUriRequest getRedirect(HttpRequest request, HttpResponse response, HttpContext context)
    throws ProtocolException
  {
    URI uri = handler.getLocationURI(response, context);
    String method = request.getRequestLine().getMethod();
    if (method.equalsIgnoreCase("HEAD")) {
      return new HttpHead(uri);
    }
    return new HttpGet(uri);
  }
  
  public RedirectHandler getHandler()
  {
    return handler;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultRedirectStrategyAdaptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
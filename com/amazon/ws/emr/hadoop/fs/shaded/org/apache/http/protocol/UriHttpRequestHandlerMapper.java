package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Contract(threading=ThreadingBehavior.SAFE)
public class UriHttpRequestHandlerMapper
  implements HttpRequestHandlerMapper
{
  private final UriPatternMatcher<HttpRequestHandler> matcher;
  
  protected UriHttpRequestHandlerMapper(UriPatternMatcher<HttpRequestHandler> matcher)
  {
    this.matcher = ((UriPatternMatcher)Args.notNull(matcher, "Pattern matcher"));
  }
  
  public UriHttpRequestHandlerMapper()
  {
    this(new UriPatternMatcher());
  }
  
  public void register(String pattern, HttpRequestHandler handler)
  {
    Args.notNull(pattern, "Pattern");
    Args.notNull(handler, "Handler");
    matcher.register(pattern, handler);
  }
  
  public void unregister(String pattern)
  {
    matcher.unregister(pattern);
  }
  
  protected String getRequestPath(HttpRequest request)
  {
    String uriPath = request.getRequestLine().getUri();
    int index = uriPath.indexOf('?');
    if (index != -1)
    {
      uriPath = uriPath.substring(0, index);
    }
    else
    {
      index = uriPath.indexOf('#');
      if (index != -1) {
        uriPath = uriPath.substring(0, index);
      }
    }
    return uriPath;
  }
  
  public HttpRequestHandler lookup(HttpRequest request)
  {
    Args.notNull(request, "HTTP request");
    return (HttpRequestHandler)matcher.lookup(getRequestPath(request));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.UriHttpRequestHandlerMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
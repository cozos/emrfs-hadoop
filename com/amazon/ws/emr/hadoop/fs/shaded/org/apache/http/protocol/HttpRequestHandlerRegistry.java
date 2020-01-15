package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.Map;

@Deprecated
@Contract(threading=ThreadingBehavior.SAFE)
public class HttpRequestHandlerRegistry
  implements HttpRequestHandlerResolver
{
  private final UriPatternMatcher<HttpRequestHandler> matcher;
  
  public HttpRequestHandlerRegistry()
  {
    matcher = new UriPatternMatcher();
  }
  
  public void register(String pattern, HttpRequestHandler handler)
  {
    Args.notNull(pattern, "URI request pattern");
    Args.notNull(handler, "Request handler");
    matcher.register(pattern, handler);
  }
  
  public void unregister(String pattern)
  {
    matcher.unregister(pattern);
  }
  
  public void setHandlers(Map<String, HttpRequestHandler> map)
  {
    matcher.setObjects(map);
  }
  
  public Map<String, HttpRequestHandler> getHandlers()
  {
    return matcher.getObjects();
  }
  
  public HttpRequestHandler lookup(String requestURI)
  {
    return (HttpRequestHandler)matcher.lookup(requestURI);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpRequestHandlerRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
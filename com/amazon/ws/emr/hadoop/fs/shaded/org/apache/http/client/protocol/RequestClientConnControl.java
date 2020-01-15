package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.RouteInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RequestClientConnControl
  implements HttpRequestInterceptor
{
  private final Log log = LogFactory.getLog(getClass());
  private static final String PROXY_CONN_DIRECTIVE = "Proxy-Connection";
  
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    
    String method = request.getRequestLine().getMethod();
    if (method.equalsIgnoreCase("CONNECT"))
    {
      request.setHeader("Proxy-Connection", "Keep-Alive");
      return;
    }
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    
    RouteInfo route = clientContext.getHttpRoute();
    if (route == null)
    {
      log.debug("Connection route not set in the context");
      return;
    }
    if (((route.getHopCount() == 1) || (route.isTunnelled())) && 
      (!request.containsHeader("Connection"))) {
      request.addHeader("Connection", "Keep-Alive");
    }
    if ((route.getHopCount() == 2) && (!route.isTunnelled()) && 
      (!request.containsHeader("Proxy-Connection"))) {
      request.addHeader("Proxy-Connection", "Keep-Alive");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestClientConnControl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
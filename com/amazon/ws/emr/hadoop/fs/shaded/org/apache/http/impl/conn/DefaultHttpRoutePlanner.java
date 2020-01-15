package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params.ConnRouteParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoutePlanner;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.Scheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Asserts;
import java.net.InetAddress;

@Deprecated
@Contract(threading=ThreadingBehavior.SAFE)
public class DefaultHttpRoutePlanner
  implements HttpRoutePlanner
{
  protected final SchemeRegistry schemeRegistry;
  
  public DefaultHttpRoutePlanner(SchemeRegistry schreg)
  {
    Args.notNull(schreg, "Scheme registry");
    schemeRegistry = schreg;
  }
  
  public HttpRoute determineRoute(HttpHost target, HttpRequest request, HttpContext context)
    throws HttpException
  {
    Args.notNull(request, "HTTP request");
    
    HttpRoute route = ConnRouteParams.getForcedRoute(request.getParams());
    if (route != null) {
      return route;
    }
    Asserts.notNull(target, "Target host");
    
    InetAddress local = ConnRouteParams.getLocalAddress(request.getParams());
    
    HttpHost proxy = ConnRouteParams.getDefaultProxy(request.getParams());
    Scheme schm;
    try
    {
      schm = schemeRegistry.getScheme(target.getSchemeName());
    }
    catch (IllegalStateException ex)
    {
      throw new HttpException(ex.getMessage());
    }
    boolean secure = schm.isLayered();
    if (proxy == null) {
      route = new HttpRoute(target, local, secure);
    } else {
      route = new HttpRoute(target, local, proxy, secure);
    }
    return route;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.DefaultHttpRoutePlanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
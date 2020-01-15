package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.SchemePortResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.UnsupportedSchemeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoutePlanner;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.net.InetAddress;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultRoutePlanner
  implements HttpRoutePlanner
{
  private final SchemePortResolver schemePortResolver;
  
  public DefaultRoutePlanner(SchemePortResolver schemePortResolver)
  {
    this.schemePortResolver = (schemePortResolver != null ? schemePortResolver : DefaultSchemePortResolver.INSTANCE);
  }
  
  public HttpRoute determineRoute(HttpHost host, HttpRequest request, HttpContext context)
    throws HttpException
  {
    Args.notNull(request, "Request");
    if (host == null) {
      throw new ProtocolException("Target host is not specified");
    }
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    RequestConfig config = clientContext.getRequestConfig();
    InetAddress local = config.getLocalAddress();
    HttpHost proxy = config.getProxy();
    if (proxy == null) {
      proxy = determineProxy(host, request, context);
    }
    HttpHost target;
    if (host.getPort() <= 0) {
      try
      {
        target = new HttpHost(host.getHostName(), schemePortResolver.resolve(host), host.getSchemeName());
      }
      catch (UnsupportedSchemeException ex)
      {
        throw new HttpException(ex.getMessage());
      }
    } else {
      target = host;
    }
    boolean secure = target.getSchemeName().equalsIgnoreCase("https");
    if (proxy == null) {
      return new HttpRoute(target, local, secure);
    }
    return new HttpRoute(target, local, proxy, secure);
  }
  
  protected HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context)
    throws HttpException
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.DefaultRoutePlanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
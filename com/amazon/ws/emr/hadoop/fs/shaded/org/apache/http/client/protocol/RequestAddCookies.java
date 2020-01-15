package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CookieStore;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpUriRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.Lookup;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.RouteInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpecProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.TextUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RequestAddCookies
  implements HttpRequestInterceptor
{
  private final Log log = LogFactory.getLog(getClass());
  
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    Args.notNull(context, "HTTP context");
    
    String method = request.getRequestLine().getMethod();
    if (method.equalsIgnoreCase("CONNECT")) {
      return;
    }
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    
    CookieStore cookieStore = clientContext.getCookieStore();
    if (cookieStore == null)
    {
      log.debug("Cookie store not specified in HTTP context");
      return;
    }
    Lookup<CookieSpecProvider> registry = clientContext.getCookieSpecRegistry();
    if (registry == null)
    {
      log.debug("CookieSpec registry not specified in HTTP context");
      return;
    }
    HttpHost targetHost = clientContext.getTargetHost();
    if (targetHost == null)
    {
      log.debug("Target host not set in the context");
      return;
    }
    RouteInfo route = clientContext.getHttpRoute();
    if (route == null)
    {
      log.debug("Connection route not set in the context");
      return;
    }
    RequestConfig config = clientContext.getRequestConfig();
    String policy = config.getCookieSpec();
    if (policy == null) {
      policy = "default";
    }
    if (log.isDebugEnabled()) {
      log.debug("CookieSpec selected: " + policy);
    }
    URI requestURI = null;
    if ((request instanceof HttpUriRequest)) {
      requestURI = ((HttpUriRequest)request).getURI();
    } else {
      try
      {
        requestURI = new URI(request.getRequestLine().getUri());
      }
      catch (URISyntaxException ignore) {}
    }
    String path = requestURI != null ? requestURI.getPath() : null;
    String hostName = targetHost.getHostName();
    int port = targetHost.getPort();
    if (port < 0) {
      port = route.getTargetHost().getPort();
    }
    CookieOrigin cookieOrigin = new CookieOrigin(hostName, port >= 0 ? port : 0, !TextUtils.isEmpty(path) ? path : "/", route.isSecure());
    
    CookieSpecProvider provider = (CookieSpecProvider)registry.lookup(policy);
    if (provider == null)
    {
      if (log.isDebugEnabled()) {
        log.debug("Unsupported cookie policy: " + policy);
      }
      return;
    }
    CookieSpec cookieSpec = provider.create(clientContext);
    
    List<Cookie> cookies = cookieStore.getCookies();
    
    List<Cookie> matchedCookies = new ArrayList();
    Date now = new Date();
    boolean expired = false;
    for (Cookie cookie : cookies) {
      if (!cookie.isExpired(now))
      {
        if (cookieSpec.match(cookie, cookieOrigin))
        {
          if (log.isDebugEnabled()) {
            log.debug("Cookie " + cookie + " match " + cookieOrigin);
          }
          matchedCookies.add(cookie);
        }
      }
      else
      {
        if (log.isDebugEnabled()) {
          log.debug("Cookie " + cookie + " expired");
        }
        expired = true;
      }
    }
    if (expired) {
      cookieStore.clearExpired(now);
    }
    if (!matchedCookies.isEmpty())
    {
      List<Header> headers = cookieSpec.formatCookies(matchedCookies);
      for (Header header : headers) {
        request.addHeader(header);
      }
    }
    int ver = cookieSpec.getVersion();
    if (ver > 0)
    {
      Header header = cookieSpec.getVersionHeader();
      if (header != null) {
        request.addHeader(header);
      }
    }
    context.setAttribute("http.cookie-spec", cookieSpec);
    context.setAttribute("http.cookie-origin", cookieOrigin);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestAddCookies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
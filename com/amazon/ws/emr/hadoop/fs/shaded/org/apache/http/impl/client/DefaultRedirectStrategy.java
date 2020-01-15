package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CircularRedirectException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.RedirectStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpGet;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpHead;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpUriRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.RequestBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.URIBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.URIUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Asserts;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class DefaultRedirectStrategy
  implements RedirectStrategy
{
  private final Log log = LogFactory.getLog(getClass());
  @Deprecated
  public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
  public static final DefaultRedirectStrategy INSTANCE = new DefaultRedirectStrategy();
  private static final String[] REDIRECT_METHODS = { "GET", "HEAD" };
  
  public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context)
    throws ProtocolException
  {
    Args.notNull(request, "HTTP request");
    Args.notNull(response, "HTTP response");
    
    int statusCode = response.getStatusLine().getStatusCode();
    String method = request.getRequestLine().getMethod();
    Header locationHeader = response.getFirstHeader("location");
    switch (statusCode)
    {
    case 302: 
      return (isRedirectable(method)) && (locationHeader != null);
    case 301: 
    case 307: 
      return isRedirectable(method);
    case 303: 
      return true;
    }
    return false;
  }
  
  public URI getLocationURI(HttpRequest request, HttpResponse response, HttpContext context)
    throws ProtocolException
  {
    Args.notNull(request, "HTTP request");
    Args.notNull(response, "HTTP response");
    Args.notNull(context, "HTTP context");
    
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    
    Header locationHeader = response.getFirstHeader("location");
    if (locationHeader == null) {
      throw new ProtocolException("Received redirect response " + response.getStatusLine() + " but no location header");
    }
    String location = locationHeader.getValue();
    if (log.isDebugEnabled()) {
      log.debug("Redirect requested to location '" + location + "'");
    }
    RequestConfig config = clientContext.getRequestConfig();
    
    URI uri = createLocationURI(location);
    try
    {
      if (!uri.isAbsolute())
      {
        if (!config.isRelativeRedirectsAllowed()) {
          throw new ProtocolException("Relative redirect location '" + uri + "' not allowed");
        }
        HttpHost target = clientContext.getTargetHost();
        Asserts.notNull(target, "Target host");
        URI requestURI = new URI(request.getRequestLine().getUri());
        URI absoluteRequestURI = URIUtils.rewriteURI(requestURI, target, false);
        uri = URIUtils.resolve(absoluteRequestURI, uri);
      }
    }
    catch (URISyntaxException ex)
    {
      throw new ProtocolException(ex.getMessage(), ex);
    }
    RedirectLocations redirectLocations = (RedirectLocations)clientContext.getAttribute("http.protocol.redirect-locations");
    if (redirectLocations == null)
    {
      redirectLocations = new RedirectLocations();
      context.setAttribute("http.protocol.redirect-locations", redirectLocations);
    }
    if ((!config.isCircularRedirectsAllowed()) && 
      (redirectLocations.contains(uri))) {
      throw new CircularRedirectException("Circular redirect to '" + uri + "'");
    }
    redirectLocations.add(uri);
    return uri;
  }
  
  protected URI createLocationURI(String location)
    throws ProtocolException
  {
    try
    {
      URIBuilder b = new URIBuilder(new URI(location).normalize());
      String host = b.getHost();
      if (host != null) {
        b.setHost(host.toLowerCase(Locale.ROOT));
      }
      String path = b.getPath();
      if (TextUtils.isEmpty(path)) {
        b.setPath("/");
      }
      return b.build();
    }
    catch (URISyntaxException ex)
    {
      throw new ProtocolException("Invalid redirect URI: " + location, ex);
    }
  }
  
  protected boolean isRedirectable(String method)
  {
    for (String m : REDIRECT_METHODS) {
      if (m.equalsIgnoreCase(method)) {
        return true;
      }
    }
    return false;
  }
  
  public HttpUriRequest getRedirect(HttpRequest request, HttpResponse response, HttpContext context)
    throws ProtocolException
  {
    URI uri = getLocationURI(request, response, context);
    String method = request.getRequestLine().getMethod();
    if (method.equalsIgnoreCase("HEAD")) {
      return new HttpHead(uri);
    }
    if (method.equalsIgnoreCase("GET")) {
      return new HttpGet(uri);
    }
    int status = response.getStatusLine().getStatusCode();
    if (status == 307) {
      return RequestBuilder.copy(request).setUri(uri).build();
    }
    return new HttpGet(uri);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultRedirectStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
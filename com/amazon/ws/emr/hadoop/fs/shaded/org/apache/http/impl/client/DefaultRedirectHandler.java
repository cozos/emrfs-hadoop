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
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.RedirectHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.URIUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Asserts;
import java.net.URI;
import java.net.URISyntaxException;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class DefaultRedirectHandler
  implements RedirectHandler
{
  private final Log log = LogFactory.getLog(getClass());
  private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
  
  public boolean isRedirectRequested(HttpResponse response, HttpContext context)
  {
    Args.notNull(response, "HTTP response");
    
    int statusCode = response.getStatusLine().getStatusCode();
    switch (statusCode)
    {
    case 301: 
    case 302: 
    case 307: 
      HttpRequest request = (HttpRequest)context.getAttribute("http.request");
      
      String method = request.getRequestLine().getMethod();
      return (method.equalsIgnoreCase("GET")) || (method.equalsIgnoreCase("HEAD"));
    case 303: 
      return true;
    }
    return false;
  }
  
  public URI getLocationURI(HttpResponse response, HttpContext context)
    throws ProtocolException
  {
    Args.notNull(response, "HTTP response");
    
    Header locationHeader = response.getFirstHeader("location");
    if (locationHeader == null) {
      throw new ProtocolException("Received redirect response " + response.getStatusLine() + " but no location header");
    }
    String location = locationHeader.getValue();
    if (log.isDebugEnabled()) {
      log.debug("Redirect requested to location '" + location + "'");
    }
    URI uri;
    try
    {
      uri = new URI(location);
    }
    catch (URISyntaxException ex)
    {
      throw new ProtocolException("Invalid redirect URI: " + location, ex);
    }
    HttpParams params = response.getParams();
    if (!uri.isAbsolute())
    {
      if (params.isParameterTrue("http.protocol.reject-relative-redirect")) {
        throw new ProtocolException("Relative redirect location '" + uri + "' not allowed");
      }
      HttpHost target = (HttpHost)context.getAttribute("http.target_host");
      
      Asserts.notNull(target, "Target host");
      
      HttpRequest request = (HttpRequest)context.getAttribute("http.request");
      try
      {
        URI requestURI = new URI(request.getRequestLine().getUri());
        URI absoluteRequestURI = URIUtils.rewriteURI(requestURI, target, true);
        uri = URIUtils.resolve(absoluteRequestURI, uri);
      }
      catch (URISyntaxException ex)
      {
        throw new ProtocolException(ex.getMessage(), ex);
      }
    }
    if (params.isParameterFalse("http.protocol.allow-circular-redirects"))
    {
      RedirectLocations redirectLocations = (RedirectLocations)context.getAttribute("http.protocol.redirect-locations");
      if (redirectLocations == null)
      {
        redirectLocations = new RedirectLocations();
        context.setAttribute("http.protocol.redirect-locations", redirectLocations);
      }
      URI redirectURI;
      if (uri.getFragment() != null) {
        try
        {
          HttpHost target = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
          
          redirectURI = URIUtils.rewriteURI(uri, target, true);
        }
        catch (URISyntaxException ex)
        {
          throw new ProtocolException(ex.getMessage(), ex);
        }
      } else {
        redirectURI = uri;
      }
      if (redirectLocations.contains(redirectURI)) {
        throw new CircularRedirectException("Circular redirect to '" + redirectURI + "'");
      }
      redirectLocations.add(redirectURI);
    }
    return uri;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultRedirectHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
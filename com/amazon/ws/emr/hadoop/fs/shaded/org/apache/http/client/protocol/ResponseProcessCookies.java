package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CookieStore;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.util.List;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class ResponseProcessCookies
  implements HttpResponseInterceptor
{
  private final Log log = LogFactory.getLog(getClass());
  
  public void process(HttpResponse response, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP request");
    Args.notNull(context, "HTTP context");
    
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    
    CookieSpec cookieSpec = clientContext.getCookieSpec();
    if (cookieSpec == null)
    {
      log.debug("Cookie spec not specified in HTTP context");
      return;
    }
    CookieStore cookieStore = clientContext.getCookieStore();
    if (cookieStore == null)
    {
      log.debug("Cookie store not specified in HTTP context");
      return;
    }
    CookieOrigin cookieOrigin = clientContext.getCookieOrigin();
    if (cookieOrigin == null)
    {
      log.debug("Cookie origin not specified in HTTP context");
      return;
    }
    HeaderIterator it = response.headerIterator("Set-Cookie");
    processCookies(it, cookieSpec, cookieOrigin, cookieStore);
    if (cookieSpec.getVersion() > 0)
    {
      it = response.headerIterator("Set-Cookie2");
      processCookies(it, cookieSpec, cookieOrigin, cookieStore);
    }
  }
  
  private void processCookies(HeaderIterator iterator, CookieSpec cookieSpec, CookieOrigin cookieOrigin, CookieStore cookieStore)
  {
    while (iterator.hasNext())
    {
      Header header = iterator.nextHeader();
      try
      {
        List<Cookie> cookies = cookieSpec.parse(header, cookieOrigin);
        for (Cookie cookie : cookies) {
          try
          {
            cookieSpec.validate(cookie, cookieOrigin);
            cookieStore.addCookie(cookie);
            if (log.isDebugEnabled()) {
              log.debug("Cookie accepted [" + formatCooke(cookie) + "]");
            }
          }
          catch (MalformedCookieException ex)
          {
            if (log.isWarnEnabled()) {
              log.warn("Cookie rejected [" + formatCooke(cookie) + "] " + ex.getMessage());
            }
          }
        }
      }
      catch (MalformedCookieException ex)
      {
        if (log.isWarnEnabled()) {
          log.warn("Invalid cookie header: \"" + header + "\". " + ex.getMessage());
        }
      }
    }
  }
  
  private static String formatCooke(Cookie cookie)
  {
    StringBuilder buf = new StringBuilder();
    buf.append(cookie.getName());
    buf.append("=\"");
    String v = cookie.getValue();
    if (v != null)
    {
      if (v.length() > 100) {
        v = v.substring(0, 100) + "...";
      }
      buf.append(v);
    }
    buf.append("\"");
    buf.append(", version:");
    buf.append(Integer.toString(cookie.getVersion()));
    buf.append(", domain:");
    buf.append(cookie.getDomain());
    buf.append(", path:");
    buf.append(cookie.getPath());
    buf.append(", expiry:");
    buf.append(cookie.getExpiryDate());
    return buf.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.ResponseProcessCookies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
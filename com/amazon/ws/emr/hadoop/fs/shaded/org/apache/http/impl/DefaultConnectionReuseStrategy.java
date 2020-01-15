package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.TokenIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicTokenIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class DefaultConnectionReuseStrategy
  implements ConnectionReuseStrategy
{
  public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();
  
  public boolean keepAlive(HttpResponse response, HttpContext context)
  {
    Args.notNull(response, "HTTP response");
    Args.notNull(context, "HTTP context");
    
    HttpRequest request = (HttpRequest)context.getAttribute("http.request");
    if (request != null) {
      try
      {
        TokenIterator ti = new BasicTokenIterator(request.headerIterator("Connection"));
        while (ti.hasNext())
        {
          String token = ti.nextToken();
          if ("Close".equalsIgnoreCase(token)) {
            return false;
          }
        }
      }
      catch (ParseException px)
      {
        return false;
      }
    }
    ProtocolVersion ver = response.getStatusLine().getProtocolVersion();
    Header teh = response.getFirstHeader("Transfer-Encoding");
    if (teh != null)
    {
      if (!"chunked".equalsIgnoreCase(teh.getValue())) {
        return false;
      }
    }
    else if (canResponseHaveBody(request, response))
    {
      Header[] clhs = response.getHeaders("Content-Length");
      if (clhs.length == 1)
      {
        Header clh = clhs[0];
        try
        {
          int contentLen = Integer.parseInt(clh.getValue());
          if (contentLen < 0) {
            return false;
          }
        }
        catch (NumberFormatException ex)
        {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    HeaderIterator headerIterator = response.headerIterator("Connection");
    if (!headerIterator.hasNext()) {
      headerIterator = response.headerIterator("Proxy-Connection");
    }
    if (headerIterator.hasNext()) {
      try
      {
        TokenIterator ti = new BasicTokenIterator(headerIterator);
        boolean keepalive = false;
        while (ti.hasNext())
        {
          String token = ti.nextToken();
          if ("Close".equalsIgnoreCase(token)) {
            return false;
          }
          if ("Keep-Alive".equalsIgnoreCase(token)) {
            keepalive = true;
          }
        }
        if (keepalive) {
          return true;
        }
      }
      catch (ParseException px)
      {
        return false;
      }
    }
    return !ver.lessEquals(HttpVersion.HTTP_1_0);
  }
  
  protected TokenIterator createTokenIterator(HeaderIterator hit)
  {
    return new BasicTokenIterator(hit);
  }
  
  private boolean canResponseHaveBody(HttpRequest request, HttpResponse response)
  {
    if ((request != null) && (request.getRequestLine().getMethod().equalsIgnoreCase("HEAD"))) {
      return false;
    }
    int status = response.getStatusLine().getStatusCode();
    return (status >= 200) && (status != 204) && (status != 304) && (status != 205);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultConnectionReuseStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.MethodNotSupportedException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class DefaultHttpRequestFactory
  implements HttpRequestFactory
{
  public static final DefaultHttpRequestFactory INSTANCE = new DefaultHttpRequestFactory();
  private static final String[] RFC2616_COMMON_METHODS = { "GET" };
  private static final String[] RFC2616_ENTITY_ENC_METHODS = { "POST", "PUT" };
  private static final String[] RFC2616_SPECIAL_METHODS = { "HEAD", "OPTIONS", "DELETE", "TRACE", "CONNECT" };
  private static final String[] RFC5789_ENTITY_ENC_METHODS = { "PATCH" };
  
  private static boolean isOneOf(String[] methods, String method)
  {
    for (String method2 : methods) {
      if (method2.equalsIgnoreCase(method)) {
        return true;
      }
    }
    return false;
  }
  
  public HttpRequest newHttpRequest(RequestLine requestline)
    throws MethodNotSupportedException
  {
    Args.notNull(requestline, "Request line");
    String method = requestline.getMethod();
    if (isOneOf(RFC2616_COMMON_METHODS, method)) {
      return new BasicHttpRequest(requestline);
    }
    if (isOneOf(RFC2616_ENTITY_ENC_METHODS, method)) {
      return new BasicHttpEntityEnclosingRequest(requestline);
    }
    if (isOneOf(RFC2616_SPECIAL_METHODS, method)) {
      return new BasicHttpRequest(requestline);
    }
    if (isOneOf(RFC5789_ENTITY_ENC_METHODS, method)) {
      return new BasicHttpEntityEnclosingRequest(requestline);
    }
    throw new MethodNotSupportedException(method + " method not supported");
  }
  
  public HttpRequest newHttpRequest(String method, String uri)
    throws MethodNotSupportedException
  {
    if (isOneOf(RFC2616_COMMON_METHODS, method)) {
      return new BasicHttpRequest(method, uri);
    }
    if (isOneOf(RFC2616_ENTITY_ENC_METHODS, method)) {
      return new BasicHttpEntityEnclosingRequest(method, uri);
    }
    if (isOneOf(RFC2616_SPECIAL_METHODS, method)) {
      return new BasicHttpRequest(method, uri);
    }
    if (isOneOf(RFC5789_ENTITY_ENC_METHODS, method)) {
      return new BasicHttpEntityEnclosingRequest(method, uri);
    }
    throw new MethodNotSupportedException(method + " method not supported");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultHttpRequestFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
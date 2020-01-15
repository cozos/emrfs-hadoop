package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.utils;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

@SdkInternalApi
public final class HttpContextUtils
{
  public static final String DISABLE_SOCKET_PROXY_PROPERTY = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.disableSocketProxy";
  
  public static boolean disableSocketProxy(HttpContext ctx)
  {
    Object v = ctx.getAttribute("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.disableSocketProxy");
    return (v != null) && (((Boolean)v).booleanValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.apache.utils.HttpContextUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
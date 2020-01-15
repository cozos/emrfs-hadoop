package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

public abstract interface ConnectionReuseStrategy
{
  public abstract boolean keepAlive(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ConnectionReuseStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
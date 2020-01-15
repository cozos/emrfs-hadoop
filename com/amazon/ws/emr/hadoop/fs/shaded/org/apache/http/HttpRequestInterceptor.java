package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;

public abstract interface HttpRequestInterceptor
{
  public abstract void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    throws HttpException, IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
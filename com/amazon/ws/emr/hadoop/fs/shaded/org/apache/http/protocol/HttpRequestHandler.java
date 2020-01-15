package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import java.io.IOException;

public abstract interface HttpRequestHandler
{
  public abstract void handle(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws HttpException, IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpRequestHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
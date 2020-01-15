package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;

public abstract interface HttpRequestRetryHandler
{
  public abstract boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.HttpRequestRetryHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
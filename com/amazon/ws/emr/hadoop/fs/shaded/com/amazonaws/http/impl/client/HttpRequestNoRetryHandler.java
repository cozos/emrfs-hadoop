package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;

@ThreadSafe
public class HttpRequestNoRetryHandler
  extends DefaultHttpRequestRetryHandler
{
  public static final HttpRequestNoRetryHandler Singleton = new HttpRequestNoRetryHandler();
  
  public boolean retryRequest(IOException exception, int executionCount, HttpContext context)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.impl.client.HttpRequestNoRetryHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
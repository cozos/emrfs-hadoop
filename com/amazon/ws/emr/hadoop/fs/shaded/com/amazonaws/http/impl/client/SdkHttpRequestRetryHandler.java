package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;

@ThreadSafe
public class SdkHttpRequestRetryHandler
  extends DefaultHttpRequestRetryHandler
{
  public static final SdkHttpRequestRetryHandler Singleton = new SdkHttpRequestRetryHandler();
  
  public boolean retryRequest(IOException exception, int executionCount, HttpContext context)
  {
    boolean retry = super.retryRequest(exception, executionCount, context);
    if (retry)
    {
      AWSRequestMetrics awsRequestMetrics = (AWSRequestMetrics)context.getAttribute(AWSRequestMetrics.SIMPLE_NAME);
      if (awsRequestMetrics != null) {
        awsRequestMetrics.incrementCounter(AWSRequestMetrics.Field.HttpClientRetryCount);
      }
    }
    return retry;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.impl.client.SdkHttpRequestRetryHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
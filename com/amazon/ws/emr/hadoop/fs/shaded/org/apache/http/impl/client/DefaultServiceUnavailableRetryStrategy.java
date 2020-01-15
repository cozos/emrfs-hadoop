package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ServiceUnavailableRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class DefaultServiceUnavailableRetryStrategy
  implements ServiceUnavailableRetryStrategy
{
  private final int maxRetries;
  private final long retryInterval;
  
  public DefaultServiceUnavailableRetryStrategy(int maxRetries, int retryInterval)
  {
    Args.positive(maxRetries, "Max retries");
    Args.positive(retryInterval, "Retry interval");
    this.maxRetries = maxRetries;
    this.retryInterval = retryInterval;
  }
  
  public DefaultServiceUnavailableRetryStrategy()
  {
    this(1, 1000);
  }
  
  public boolean retryRequest(HttpResponse response, int executionCount, HttpContext context)
  {
    return (executionCount <= maxRetries) && (response.getStatusLine().getStatusCode() == 503);
  }
  
  public long getRetryInterval()
  {
    return retryInterval;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultServiceUnavailableRetryStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
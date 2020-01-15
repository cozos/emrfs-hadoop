package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionKeepAliveStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

public class SdkConnectionKeepAliveStrategy
  implements ConnectionKeepAliveStrategy
{
  private final long maxIdleTime;
  
  public SdkConnectionKeepAliveStrategy(long maxIdleTime)
  {
    this.maxIdleTime = maxIdleTime;
  }
  
  public long getKeepAliveDuration(HttpResponse response, HttpContext context)
  {
    long duration = DefaultConnectionKeepAliveStrategy.INSTANCE.getKeepAliveDuration(response, context);
    if ((0L < duration) && (duration < maxIdleTime)) {
      return duration;
    }
    return maxIdleTime;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.SdkConnectionKeepAliveStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
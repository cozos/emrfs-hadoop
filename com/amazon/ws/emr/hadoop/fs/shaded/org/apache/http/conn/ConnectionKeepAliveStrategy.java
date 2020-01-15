package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

public abstract interface ConnectionKeepAliveStrategy
{
  public abstract long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionKeepAliveStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
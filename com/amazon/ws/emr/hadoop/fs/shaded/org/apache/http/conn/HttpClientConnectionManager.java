package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract interface HttpClientConnectionManager
{
  public abstract ConnectionRequest requestConnection(HttpRoute paramHttpRoute, Object paramObject);
  
  public abstract void releaseConnection(HttpClientConnection paramHttpClientConnection, Object paramObject, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void connect(HttpClientConnection paramHttpClientConnection, HttpRoute paramHttpRoute, int paramInt, HttpContext paramHttpContext)
    throws IOException;
  
  public abstract void upgrade(HttpClientConnection paramHttpClientConnection, HttpRoute paramHttpRoute, HttpContext paramHttpContext)
    throws IOException;
  
  public abstract void routeComplete(HttpClientConnection paramHttpClientConnection, HttpRoute paramHttpRoute, HttpContext paramHttpContext)
    throws IOException;
  
  public abstract void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void closeExpiredConnections();
  
  public abstract void shutdown();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
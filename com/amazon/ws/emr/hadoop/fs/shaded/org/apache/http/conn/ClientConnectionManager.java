package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeRegistry;
import java.util.concurrent.TimeUnit;

@Deprecated
public abstract interface ClientConnectionManager
{
  public abstract SchemeRegistry getSchemeRegistry();
  
  public abstract ClientConnectionRequest requestConnection(HttpRoute paramHttpRoute, Object paramObject);
  
  public abstract void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void closeExpiredConnections();
  
  public abstract void shutdown();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
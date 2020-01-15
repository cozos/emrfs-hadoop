package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import java.util.concurrent.TimeUnit;

@Deprecated
public abstract interface ClientConnectionRequest
{
  public abstract ManagedClientConnection getConnection(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ConnectionPoolTimeoutException;
  
  public abstract void abortRequest();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
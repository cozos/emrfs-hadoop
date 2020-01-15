package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionPoolTimeoutException;
import java.util.concurrent.TimeUnit;

@Deprecated
public abstract interface PoolEntryRequest
{
  public abstract BasicPoolEntry getPoolEntry(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ConnectionPoolTimeoutException;
  
  public abstract void abortRequest();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm.PoolEntryRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
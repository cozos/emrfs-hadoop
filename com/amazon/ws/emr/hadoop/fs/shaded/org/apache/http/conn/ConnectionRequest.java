package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.concurrent.Cancellable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public abstract interface ConnectionRequest
  extends Cancellable
{
  public abstract HttpClientConnection get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
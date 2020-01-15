package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionPoolTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedClientConnection;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class PoolingClientConnectionManager$1
  implements ClientConnectionRequest
{
  PoolingClientConnectionManager$1(PoolingClientConnectionManager paramPoolingClientConnectionManager, Future paramFuture) {}
  
  public void abortRequest()
  {
    val$future.cancel(true);
  }
  
  public ManagedClientConnection getConnection(long timeout, TimeUnit tunit)
    throws InterruptedException, ConnectionPoolTimeoutException
  {
    return this$0.leaseConnection(val$future, timeout, tunit);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.PoolingClientConnectionManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
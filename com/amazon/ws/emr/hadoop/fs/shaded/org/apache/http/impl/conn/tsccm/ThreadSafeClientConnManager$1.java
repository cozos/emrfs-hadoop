package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionPoolTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.concurrent.TimeUnit;

class ThreadSafeClientConnManager$1
  implements ClientConnectionRequest
{
  ThreadSafeClientConnManager$1(ThreadSafeClientConnManager paramThreadSafeClientConnManager, PoolEntryRequest paramPoolEntryRequest, HttpRoute paramHttpRoute) {}
  
  public void abortRequest()
  {
    val$poolRequest.abortRequest();
  }
  
  public ManagedClientConnection getConnection(long timeout, TimeUnit tunit)
    throws InterruptedException, ConnectionPoolTimeoutException
  {
    Args.notNull(val$route, "Route");
    if (ThreadSafeClientConnManager.access$000(this$0).isDebugEnabled()) {
      ThreadSafeClientConnManager.access$000(this$0).debug("Get connection: " + val$route + ", timeout = " + timeout);
    }
    BasicPoolEntry entry = val$poolRequest.getPoolEntry(timeout, tunit);
    return new BasicPooledConnAdapter(this$0, entry);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import java.util.concurrent.TimeUnit;

class SingleClientConnManager$1
  implements ClientConnectionRequest
{
  SingleClientConnManager$1(SingleClientConnManager paramSingleClientConnManager, HttpRoute paramHttpRoute, Object paramObject) {}
  
  public void abortRequest() {}
  
  public ManagedClientConnection getConnection(long timeout, TimeUnit tunit)
  {
    return this$0.getConnection(val$route, val$state);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.SingleClientConnManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
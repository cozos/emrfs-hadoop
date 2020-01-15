package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import java.util.concurrent.TimeUnit;

class BasicClientConnectionManager$1
  implements ClientConnectionRequest
{
  BasicClientConnectionManager$1(BasicClientConnectionManager paramBasicClientConnectionManager, HttpRoute paramHttpRoute, Object paramObject) {}
  
  public void abortRequest() {}
  
  public ManagedClientConnection getConnection(long timeout, TimeUnit tunit)
  {
    return this$0.getConnection(val$route, val$state);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.BasicClientConnectionManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
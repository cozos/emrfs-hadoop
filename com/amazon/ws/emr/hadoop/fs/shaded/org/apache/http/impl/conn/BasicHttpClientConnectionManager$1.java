package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import java.util.concurrent.TimeUnit;

class BasicHttpClientConnectionManager$1
  implements ConnectionRequest
{
  BasicHttpClientConnectionManager$1(BasicHttpClientConnectionManager paramBasicHttpClientConnectionManager, HttpRoute paramHttpRoute, Object paramObject) {}
  
  public boolean cancel()
  {
    return false;
  }
  
  public HttpClientConnection get(long timeout, TimeUnit tunit)
  {
    return this$0.getConnection(val$route, val$state);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.BasicHttpClientConnectionManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
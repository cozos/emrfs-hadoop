package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.SocketConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionPoolTimeoutException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class PoolingHttpClientConnectionManager$1
  implements ConnectionRequest
{
  PoolingHttpClientConnectionManager$1(PoolingHttpClientConnectionManager paramPoolingHttpClientConnectionManager, Future paramFuture, HttpRoute paramHttpRoute) {}
  
  public boolean cancel()
  {
    return val$future.cancel(true);
  }
  
  public HttpClientConnection get(long timeout, TimeUnit tunit)
    throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException
  {
    HttpClientConnection conn = this$0.leaseConnection(val$future, timeout, tunit);
    if (conn.isOpen())
    {
      HttpHost host;
      HttpHost host;
      if (val$route.getProxyHost() != null) {
        host = val$route.getProxyHost();
      } else {
        host = val$route.getTargetHost();
      }
      SocketConfig socketConfig = PoolingHttpClientConnectionManager.access$000(this$0, host);
      conn.setSocketTimeout(socketConfig.getSoTimeout());
    }
    return conn;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.PoolingHttpClientConnectionManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
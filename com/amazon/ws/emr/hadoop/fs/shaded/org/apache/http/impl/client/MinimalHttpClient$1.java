package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeRegistry;
import java.util.concurrent.TimeUnit;

class MinimalHttpClient$1
  implements ClientConnectionManager
{
  MinimalHttpClient$1(MinimalHttpClient paramMinimalHttpClient) {}
  
  public void shutdown()
  {
    MinimalHttpClient.access$000(this$0).shutdown();
  }
  
  public ClientConnectionRequest requestConnection(HttpRoute route, Object state)
  {
    throw new UnsupportedOperationException();
  }
  
  public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public SchemeRegistry getSchemeRegistry()
  {
    throw new UnsupportedOperationException();
  }
  
  public void closeIdleConnections(long idletime, TimeUnit tunit)
  {
    MinimalHttpClient.access$000(this$0).closeIdleConnections(idletime, tunit);
  }
  
  public void closeExpiredConnections()
  {
    MinimalHttpClient.access$000(this$0).closeExpiredConnections();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.MinimalHttpClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
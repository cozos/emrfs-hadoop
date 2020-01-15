package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.ConnectionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpConnectionFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedHttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.ConnFactory;
import java.io.IOException;

class PoolingHttpClientConnectionManager$InternalConnectionFactory
  implements ConnFactory<HttpRoute, ManagedHttpClientConnection>
{
  private final PoolingHttpClientConnectionManager.ConfigData configData;
  private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
  
  PoolingHttpClientConnectionManager$InternalConnectionFactory(PoolingHttpClientConnectionManager.ConfigData configData, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory)
  {
    this.configData = (configData != null ? configData : new PoolingHttpClientConnectionManager.ConfigData());
    this.connFactory = (connFactory != null ? connFactory : ManagedHttpClientConnectionFactory.INSTANCE);
  }
  
  public ManagedHttpClientConnection create(HttpRoute route)
    throws IOException
  {
    ConnectionConfig config = null;
    if (route.getProxyHost() != null) {
      config = configData.getConnectionConfig(route.getProxyHost());
    }
    if (config == null) {
      config = configData.getConnectionConfig(route.getTargetHost());
    }
    if (config == null) {
      config = configData.getDefaultConnectionConfig();
    }
    if (config == null) {
      config = ConnectionConfig.DEFAULT;
    }
    return (ManagedHttpClientConnection)connFactory.create(route, config);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.PoolingHttpClientConnectionManager.InternalConnectionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
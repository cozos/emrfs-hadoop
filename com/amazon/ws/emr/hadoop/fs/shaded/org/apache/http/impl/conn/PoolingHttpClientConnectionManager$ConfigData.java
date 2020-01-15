package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.ConnectionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.SocketConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class PoolingHttpClientConnectionManager$ConfigData
{
  private final Map<HttpHost, SocketConfig> socketConfigMap;
  private final Map<HttpHost, ConnectionConfig> connectionConfigMap;
  private volatile SocketConfig defaultSocketConfig;
  private volatile ConnectionConfig defaultConnectionConfig;
  
  PoolingHttpClientConnectionManager$ConfigData()
  {
    socketConfigMap = new ConcurrentHashMap();
    connectionConfigMap = new ConcurrentHashMap();
  }
  
  public SocketConfig getDefaultSocketConfig()
  {
    return defaultSocketConfig;
  }
  
  public void setDefaultSocketConfig(SocketConfig defaultSocketConfig)
  {
    this.defaultSocketConfig = defaultSocketConfig;
  }
  
  public ConnectionConfig getDefaultConnectionConfig()
  {
    return defaultConnectionConfig;
  }
  
  public void setDefaultConnectionConfig(ConnectionConfig defaultConnectionConfig)
  {
    this.defaultConnectionConfig = defaultConnectionConfig;
  }
  
  public SocketConfig getSocketConfig(HttpHost host)
  {
    return (SocketConfig)socketConfigMap.get(host);
  }
  
  public void setSocketConfig(HttpHost host, SocketConfig socketConfig)
  {
    socketConfigMap.put(host, socketConfig);
  }
  
  public ConnectionConfig getConnectionConfig(HttpHost host)
  {
    return (ConnectionConfig)connectionConfigMap.get(host);
  }
  
  public void setConnectionConfig(HttpHost host, ConnectionConfig connectionConfig)
  {
    connectionConfigMap.put(host, connectionConfig);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.PoolingHttpClientConnectionManager.ConfigData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
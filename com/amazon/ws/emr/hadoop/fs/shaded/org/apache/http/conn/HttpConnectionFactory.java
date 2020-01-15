package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.ConnectionConfig;

public abstract interface HttpConnectionFactory<T, C extends HttpConnection>
{
  public abstract C create(T paramT, ConnectionConfig paramConnectionConfig);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpConnectionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
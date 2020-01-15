package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpInetConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import javax.net.ssl.SSLSession;

@Deprecated
public abstract interface HttpRoutedConnection
  extends HttpInetConnection
{
  public abstract boolean isSecure();
  
  public abstract HttpRoute getRoute();
  
  public abstract SSLSession getSSLSession();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpRoutedConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
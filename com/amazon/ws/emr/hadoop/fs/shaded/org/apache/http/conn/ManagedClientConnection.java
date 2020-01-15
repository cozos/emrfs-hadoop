package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;

@Deprecated
public abstract interface ManagedClientConnection
  extends HttpClientConnection, HttpRoutedConnection, ManagedHttpClientConnection, ConnectionReleaseTrigger
{
  public abstract boolean isSecure();
  
  public abstract HttpRoute getRoute();
  
  public abstract SSLSession getSSLSession();
  
  public abstract void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams)
    throws IOException;
  
  public abstract void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams)
    throws IOException;
  
  public abstract void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams)
    throws IOException;
  
  public abstract void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams)
    throws IOException;
  
  public abstract void markReusable();
  
  public abstract void unmarkReusable();
  
  public abstract boolean isMarkedReusable();
  
  public abstract void setState(Object paramObject);
  
  public abstract Object getState();
  
  public abstract void setIdleDuration(long paramLong, TimeUnit paramTimeUnit);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedClientConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
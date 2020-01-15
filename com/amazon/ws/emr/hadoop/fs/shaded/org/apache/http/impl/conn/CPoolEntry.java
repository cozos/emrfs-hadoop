package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedHttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.PoolEntry;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Contract(threading=ThreadingBehavior.SAFE)
class CPoolEntry
  extends PoolEntry<HttpRoute, ManagedHttpClientConnection>
{
  private final Log log;
  private volatile boolean routeComplete;
  
  public CPoolEntry(Log log, String id, HttpRoute route, ManagedHttpClientConnection conn, long timeToLive, TimeUnit tunit)
  {
    super(id, route, conn, timeToLive, tunit);
    this.log = log;
  }
  
  public void markRouteComplete()
  {
    routeComplete = true;
  }
  
  public boolean isRouteComplete()
  {
    return routeComplete;
  }
  
  public void closeConnection()
    throws IOException
  {
    HttpClientConnection conn = (HttpClientConnection)getConnection();
    conn.close();
  }
  
  public void shutdownConnection()
    throws IOException
  {
    HttpClientConnection conn = (HttpClientConnection)getConnection();
    conn.shutdown();
  }
  
  public boolean isExpired(long now)
  {
    boolean expired = super.isExpired(now);
    if ((expired) && (log.isDebugEnabled())) {
      log.debug("Connection " + this + " expired @ " + new Date(getExpiry()));
    }
    return expired;
  }
  
  public boolean isClosed()
  {
    HttpClientConnection conn = (HttpClientConnection)getConnection();
    return !conn.isOpen();
  }
  
  public void close()
  {
    try
    {
      closeConnection();
    }
    catch (IOException ex)
    {
      log.debug("I/O error closing connection", ex);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.CPoolEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
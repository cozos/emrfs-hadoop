package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.OperatedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.RouteTracker;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.PoolEntry;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Deprecated
class HttpPoolEntry
  extends PoolEntry<HttpRoute, OperatedClientConnection>
{
  private final Log log;
  private final RouteTracker tracker;
  
  public HttpPoolEntry(Log log, String id, HttpRoute route, OperatedClientConnection conn, long timeToLive, TimeUnit tunit)
  {
    super(id, route, conn, timeToLive, tunit);
    this.log = log;
    tracker = new RouteTracker(route);
  }
  
  public boolean isExpired(long now)
  {
    boolean expired = super.isExpired(now);
    if ((expired) && (log.isDebugEnabled())) {
      log.debug("Connection " + this + " expired @ " + new Date(getExpiry()));
    }
    return expired;
  }
  
  RouteTracker getTracker()
  {
    return tracker;
  }
  
  HttpRoute getPlannedRoute()
  {
    return (HttpRoute)getRoute();
  }
  
  HttpRoute getEffectiveRoute()
  {
    return tracker.toRoute();
  }
  
  public boolean isClosed()
  {
    OperatedClientConnection conn = (OperatedClientConnection)getConnection();
    return !conn.isOpen();
  }
  
  public void close()
  {
    OperatedClientConnection conn = (OperatedClientConnection)getConnection();
    try
    {
      conn.close();
    }
    catch (IOException ex)
    {
      log.debug("I/O error closing connection", ex);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.HttpPoolEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
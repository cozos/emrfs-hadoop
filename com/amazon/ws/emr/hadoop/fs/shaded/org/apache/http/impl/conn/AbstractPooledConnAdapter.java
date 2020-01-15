package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.OperatedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.RouteTracker;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;

@Deprecated
public abstract class AbstractPooledConnAdapter
  extends AbstractClientConnAdapter
{
  protected volatile AbstractPoolEntry poolEntry;
  
  protected AbstractPooledConnAdapter(ClientConnectionManager manager, AbstractPoolEntry entry)
  {
    super(manager, connection);
    poolEntry = entry;
  }
  
  public String getId()
  {
    return null;
  }
  
  @Deprecated
  protected AbstractPoolEntry getPoolEntry()
  {
    return poolEntry;
  }
  
  protected void assertValid(AbstractPoolEntry entry)
  {
    if ((isReleased()) || (entry == null)) {
      throw new ConnectionShutdownException();
    }
  }
  
  @Deprecated
  protected final void assertAttached()
  {
    if (poolEntry == null) {
      throw new ConnectionShutdownException();
    }
  }
  
  protected synchronized void detach()
  {
    poolEntry = null;
    super.detach();
  }
  
  public HttpRoute getRoute()
  {
    AbstractPoolEntry entry = getPoolEntry();
    assertValid(entry);
    return tracker == null ? null : tracker.toRoute();
  }
  
  public void open(HttpRoute route, HttpContext context, HttpParams params)
    throws IOException
  {
    AbstractPoolEntry entry = getPoolEntry();
    assertValid(entry);
    entry.open(route, context, params);
  }
  
  public void tunnelTarget(boolean secure, HttpParams params)
    throws IOException
  {
    AbstractPoolEntry entry = getPoolEntry();
    assertValid(entry);
    entry.tunnelTarget(secure, params);
  }
  
  public void tunnelProxy(HttpHost next, boolean secure, HttpParams params)
    throws IOException
  {
    AbstractPoolEntry entry = getPoolEntry();
    assertValid(entry);
    entry.tunnelProxy(next, secure, params);
  }
  
  public void layerProtocol(HttpContext context, HttpParams params)
    throws IOException
  {
    AbstractPoolEntry entry = getPoolEntry();
    assertValid(entry);
    entry.layerProtocol(context, params);
  }
  
  public void close()
    throws IOException
  {
    AbstractPoolEntry entry = getPoolEntry();
    if (entry != null) {
      entry.shutdownEntry();
    }
    OperatedClientConnection conn = getWrappedConnection();
    if (conn != null) {
      conn.close();
    }
  }
  
  public void shutdown()
    throws IOException
  {
    AbstractPoolEntry entry = getPoolEntry();
    if (entry != null) {
      entry.shutdownEntry();
    }
    OperatedClientConnection conn = getWrappedConnection();
    if (conn != null) {
      conn.shutdown();
    }
  }
  
  public Object getState()
  {
    AbstractPoolEntry entry = getPoolEntry();
    assertValid(entry);
    return entry.getState();
  }
  
  public void setState(Object state)
  {
    AbstractPoolEntry entry = getPoolEntry();
    assertValid(entry);
    entry.setState(state);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.AbstractPooledConnAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
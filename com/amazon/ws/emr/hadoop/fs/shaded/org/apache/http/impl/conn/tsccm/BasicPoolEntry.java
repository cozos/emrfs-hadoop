package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.OperatedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.AbstractPoolEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

@Deprecated
public class BasicPoolEntry
  extends AbstractPoolEntry
{
  private final long created;
  private long updated;
  private final long validUntil;
  private long expiry;
  
  public BasicPoolEntry(ClientConnectionOperator op, HttpRoute route, ReferenceQueue<Object> queue)
  {
    super(op, route);
    Args.notNull(route, "HTTP route");
    created = System.currentTimeMillis();
    validUntil = Long.MAX_VALUE;
    expiry = validUntil;
  }
  
  public BasicPoolEntry(ClientConnectionOperator op, HttpRoute route)
  {
    this(op, route, -1L, TimeUnit.MILLISECONDS);
  }
  
  public BasicPoolEntry(ClientConnectionOperator op, HttpRoute route, long connTTL, TimeUnit timeunit)
  {
    super(op, route);
    Args.notNull(route, "HTTP route");
    created = System.currentTimeMillis();
    if (connTTL > 0L) {
      validUntil = (created + timeunit.toMillis(connTTL));
    } else {
      validUntil = Long.MAX_VALUE;
    }
    expiry = validUntil;
  }
  
  protected final OperatedClientConnection getConnection()
  {
    return connection;
  }
  
  protected final HttpRoute getPlannedRoute()
  {
    return route;
  }
  
  protected final BasicPoolEntryRef getWeakRef()
  {
    return null;
  }
  
  protected void shutdownEntry()
  {
    super.shutdownEntry();
  }
  
  public long getCreated()
  {
    return created;
  }
  
  public long getUpdated()
  {
    return updated;
  }
  
  public long getExpiry()
  {
    return expiry;
  }
  
  public long getValidUntil()
  {
    return validUntil;
  }
  
  public void updateExpiry(long time, TimeUnit timeunit)
  {
    updated = System.currentTimeMillis();
    long newExpiry;
    long newExpiry;
    if (time > 0L) {
      newExpiry = updated + timeunit.toMillis(time);
    } else {
      newExpiry = Long.MAX_VALUE;
    }
    expiry = Math.min(validUntil, newExpiry);
  }
  
  public boolean isExpired(long now)
  {
    return now >= expiry;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm.BasicPoolEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
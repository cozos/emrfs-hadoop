package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.OperatedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.AbstractConnPool;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.ConnFactory;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Deprecated
class HttpConnPool
  extends AbstractConnPool<HttpRoute, OperatedClientConnection, HttpPoolEntry>
{
  private static final AtomicLong COUNTER = new AtomicLong();
  private final Log log;
  private final long timeToLive;
  private final TimeUnit tunit;
  
  public HttpConnPool(Log log, ClientConnectionOperator connOperator, int defaultMaxPerRoute, int maxTotal, long timeToLive, TimeUnit tunit)
  {
    super(new InternalConnFactory(connOperator), defaultMaxPerRoute, maxTotal);
    this.log = log;
    this.timeToLive = timeToLive;
    this.tunit = tunit;
  }
  
  protected HttpPoolEntry createEntry(HttpRoute route, OperatedClientConnection conn)
  {
    String id = Long.toString(COUNTER.getAndIncrement());
    return new HttpPoolEntry(log, id, route, conn, timeToLive, tunit);
  }
  
  static class InternalConnFactory
    implements ConnFactory<HttpRoute, OperatedClientConnection>
  {
    private final ClientConnectionOperator connOperator;
    
    InternalConnFactory(ClientConnectionOperator connOperator)
    {
      this.connOperator = connOperator;
    }
    
    public OperatedClientConnection create(HttpRoute route)
      throws IOException
    {
      return connOperator.createConnection();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.HttpConnPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
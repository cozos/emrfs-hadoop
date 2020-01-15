package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;

public class SingleClientConnManager$ConnAdapter
  extends AbstractPooledConnAdapter
{
  protected SingleClientConnManager$ConnAdapter(SingleClientConnManager paramSingleClientConnManager, SingleClientConnManager.PoolEntry entry, HttpRoute route)
  {
    super(paramSingleClientConnManager, entry);
    markReusable();
    route = route;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.SingleClientConnManager.ConnAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
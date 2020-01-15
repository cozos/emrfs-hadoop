package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

@Deprecated
public class BasicPoolEntryRef
  extends WeakReference<BasicPoolEntry>
{
  private final HttpRoute route;
  
  public BasicPoolEntryRef(BasicPoolEntry entry, ReferenceQueue<Object> queue)
  {
    super(entry, queue);
    Args.notNull(entry, "Pool entry");
    route = entry.getPlannedRoute();
  }
  
  public final HttpRoute getRoute()
  {
    return route;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm.BasicPoolEntryRef
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
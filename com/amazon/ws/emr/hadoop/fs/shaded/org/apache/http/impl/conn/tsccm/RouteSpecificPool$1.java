package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params.ConnPerRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;

class RouteSpecificPool$1
  implements ConnPerRoute
{
  RouteSpecificPool$1(RouteSpecificPool paramRouteSpecificPool) {}
  
  public int getMaxForRoute(HttpRoute unused)
  {
    return this$0.maxEntries;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm.RouteSpecificPool.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
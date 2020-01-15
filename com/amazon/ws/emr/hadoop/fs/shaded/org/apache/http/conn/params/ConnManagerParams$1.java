package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;

final class ConnManagerParams$1
  implements ConnPerRoute
{
  public int getMaxForRoute(HttpRoute route)
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params.ConnManagerParams.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
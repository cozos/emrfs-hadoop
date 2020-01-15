package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;

@Deprecated
public abstract interface ConnPerRoute
{
  public abstract int getMaxForRoute(HttpRoute paramHttpRoute);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params.ConnPerRoute
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
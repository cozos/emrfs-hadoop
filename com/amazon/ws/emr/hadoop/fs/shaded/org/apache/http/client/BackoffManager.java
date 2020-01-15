package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;

public abstract interface BackoffManager
{
  public abstract void backOff(HttpRoute paramHttpRoute);
  
  public abstract void probe(HttpRoute paramHttpRoute);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.BackoffManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
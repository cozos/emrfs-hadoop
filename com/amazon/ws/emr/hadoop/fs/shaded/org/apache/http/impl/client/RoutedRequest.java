package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;

@Deprecated
public class RoutedRequest
{
  protected final RequestWrapper request;
  protected final HttpRoute route;
  
  public RoutedRequest(RequestWrapper req, HttpRoute route)
  {
    request = req;
    this.route = route;
  }
  
  public final RequestWrapper getRequest()
  {
    return request;
  }
  
  public final HttpRoute getRoute()
  {
    return route;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.RoutedRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
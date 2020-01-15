package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpAbstractParamBean;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.net.InetAddress;

@Deprecated
public class ConnRouteParamBean
  extends HttpAbstractParamBean
{
  public ConnRouteParamBean(HttpParams params)
  {
    super(params);
  }
  
  public void setDefaultProxy(HttpHost defaultProxy)
  {
    params.setParameter("http.route.default-proxy", defaultProxy);
  }
  
  public void setLocalAddress(InetAddress address)
  {
    params.setParameter("http.route.local-address", address);
  }
  
  public void setForcedRoute(HttpRoute route)
  {
    params.setParameter("http.route.forced-route", route);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params.ConnRouteParamBean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
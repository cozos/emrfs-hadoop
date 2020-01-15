package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.SchemePortResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultProxyRoutePlanner
  extends DefaultRoutePlanner
{
  private final HttpHost proxy;
  
  public DefaultProxyRoutePlanner(HttpHost proxy, SchemePortResolver schemePortResolver)
  {
    super(schemePortResolver);
    this.proxy = ((HttpHost)Args.notNull(proxy, "Proxy host"));
  }
  
  public DefaultProxyRoutePlanner(HttpHost proxy)
  {
    this(proxy, null);
  }
  
  protected HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context)
    throws HttpException
  {
    return proxy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.DefaultProxyRoutePlanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
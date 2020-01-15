package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoutePlanner;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.NoConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.PoolingClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.SchemeRegistryFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.net.ProxySelector;

@Deprecated
@Contract(threading=ThreadingBehavior.SAFE_CONDITIONAL)
public class SystemDefaultHttpClient
  extends DefaultHttpClient
{
  public SystemDefaultHttpClient(HttpParams params)
  {
    super(null, params);
  }
  
  public SystemDefaultHttpClient()
  {
    super(null, null);
  }
  
  protected ClientConnectionManager createClientConnectionManager()
  {
    PoolingClientConnectionManager connmgr = new PoolingClientConnectionManager(SchemeRegistryFactory.createSystemDefault());
    
    String s = System.getProperty("http.keepAlive", "true");
    if ("true".equalsIgnoreCase(s))
    {
      s = System.getProperty("http.maxConnections", "5");
      int max = Integer.parseInt(s);
      connmgr.setDefaultMaxPerRoute(max);
      connmgr.setMaxTotal(2 * max);
    }
    return connmgr;
  }
  
  protected HttpRoutePlanner createHttpRoutePlanner()
  {
    return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), ProxySelector.getDefault());
  }
  
  protected ConnectionReuseStrategy createConnectionReuseStrategy()
  {
    String s = System.getProperty("http.keepAlive", "true");
    if ("true".equalsIgnoreCase(s)) {
      return new DefaultConnectionReuseStrategy();
    }
    return new NoConnectionReuseStrategy();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.SystemDefaultHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
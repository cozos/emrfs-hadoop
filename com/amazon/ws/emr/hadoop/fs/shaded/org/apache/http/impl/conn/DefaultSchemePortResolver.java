package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.SchemePortResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.UnsupportedSchemeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class DefaultSchemePortResolver
  implements SchemePortResolver
{
  public static final DefaultSchemePortResolver INSTANCE = new DefaultSchemePortResolver();
  
  public int resolve(HttpHost host)
    throws UnsupportedSchemeException
  {
    Args.notNull(host, "HTTP host");
    int port = host.getPort();
    if (port > 0) {
      return port;
    }
    String name = host.getSchemeName();
    if (name.equalsIgnoreCase("http")) {
      return 80;
    }
    if (name.equalsIgnoreCase("https")) {
      return 443;
    }
    throw new UnsupportedSchemeException(name + " protocol is not supported");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.DefaultSchemePortResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
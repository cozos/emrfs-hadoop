package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.PlainSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.Scheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.SSLSocketFactory;

@Deprecated
@Contract(threading=ThreadingBehavior.SAFE)
public final class SchemeRegistryFactory
{
  public static SchemeRegistry createDefault()
  {
    SchemeRegistry registry = new SchemeRegistry();
    registry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
    
    registry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
    
    return registry;
  }
  
  public static SchemeRegistry createSystemDefault()
  {
    SchemeRegistry registry = new SchemeRegistry();
    registry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
    
    registry.register(new Scheme("https", 443, SSLSocketFactory.getSystemSocketFactory()));
    
    return registry;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.SchemeRegistryFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
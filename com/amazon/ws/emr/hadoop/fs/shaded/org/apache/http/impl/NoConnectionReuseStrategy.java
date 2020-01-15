package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class NoConnectionReuseStrategy
  implements ConnectionReuseStrategy
{
  public static final NoConnectionReuseStrategy INSTANCE = new NoConnectionReuseStrategy();
  
  public boolean keepAlive(HttpResponse response, HttpContext context)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.NoConnectionReuseStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
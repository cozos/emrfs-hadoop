package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ClientConnectionManagerFactory$Handler
  implements InvocationHandler
{
  private final HttpClientConnectionManager orig;
  
  ClientConnectionManagerFactory$Handler(HttpClientConnectionManager real)
  {
    orig = real;
  }
  
  public Object invoke(Object proxy, Method method, Object[] args)
    throws Throwable
  {
    try
    {
      Object ret = method.invoke(orig, args);
      return (ret instanceof ConnectionRequest) ? 
        ClientConnectionRequestFactory.wrap((ConnectionRequest)ret) : ret;
    }
    catch (InvocationTargetException e)
    {
      ClientConnectionManagerFactory.access$000().debug("", e);
      throw e.getCause();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ClientConnectionManagerFactory.Handler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
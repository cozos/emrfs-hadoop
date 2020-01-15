package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.ConnPoolControl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ClientConnectionManagerFactory
{
  private static final Log log = LogFactory.getLog(ClientConnectionManagerFactory.class);
  
  public static HttpClientConnectionManager wrap(HttpClientConnectionManager orig)
  {
    if ((orig instanceof Wrapped)) {
      throw new IllegalArgumentException();
    }
    Class<?>[] interfaces;
    Class<?>[] interfaces;
    if ((orig instanceof ConnPoolControl)) {
      interfaces = new Class[] { HttpClientConnectionManager.class, ConnPoolControl.class, Wrapped.class };
    } else {
      interfaces = new Class[] { HttpClientConnectionManager.class, Wrapped.class };
    }
    return (HttpClientConnectionManager)Proxy.newProxyInstance(ClientConnectionManagerFactory.class
    
      .getClassLoader(), interfaces, new Handler(orig));
  }
  
  private static class Handler
    implements InvocationHandler
  {
    private final HttpClientConnectionManager orig;
    
    Handler(HttpClientConnectionManager real)
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
        ClientConnectionManagerFactory.log.debug("", e);
        throw e.getCause();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ClientConnectionManagerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
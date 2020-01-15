package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.AwsSdkMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ServiceLatencyProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ServiceMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSServiceMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class ClientConnectionRequestFactory
{
  private static final Log log = LogFactory.getLog(ClientConnectionRequestFactory.class);
  private static final Class<?>[] interfaces = { ConnectionRequest.class, Wrapped.class };
  
  static ConnectionRequest wrap(ConnectionRequest orig)
  {
    if ((orig instanceof Wrapped)) {
      throw new IllegalArgumentException();
    }
    return (ConnectionRequest)Proxy.newProxyInstance(ClientConnectionRequestFactory.class
    
      .getClassLoader(), interfaces, new Handler(orig));
  }
  
  private static class Handler
    implements InvocationHandler
  {
    private final ConnectionRequest orig;
    
    Handler(ConnectionRequest orig)
    {
      this.orig = orig;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args)
      throws Throwable
    {
      try
      {
        if ("get".equals(method.getName()))
        {
          ServiceLatencyProvider latencyProvider = new ServiceLatencyProvider(AWSServiceMetrics.HttpClientGetConnectionTime);
          try
          {
            return method.invoke(orig, args);
          }
          finally
          {
            AwsSdkMetrics.getServiceMetricCollector().collectLatency(latencyProvider.endTiming());
          }
        }
        return method.invoke(orig, args);
      }
      catch (InvocationTargetException e)
      {
        ClientConnectionRequestFactory.log.debug("", e);
        throw e.getCause();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ClientConnectionRequestFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
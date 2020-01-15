package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.AwsSdkMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ServiceLatencyProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ServiceMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSServiceMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ClientConnectionRequestFactory$Handler
  implements InvocationHandler
{
  private final ConnectionRequest orig;
  
  ClientConnectionRequestFactory$Handler(ConnectionRequest orig)
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
      ClientConnectionRequestFactory.access$000().debug("", e);
      throw e.getCause();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ClientConnectionRequestFactory.Handler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
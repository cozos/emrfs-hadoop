package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;

public abstract class RequestMetricCollector
{
  public abstract void collectMetrics(Request<?> paramRequest, Response<?> paramResponse);
  
  public boolean isEnabled()
  {
    return true;
  }
  
  public static final RequestMetricCollector NONE = new RequestMetricCollector()
  {
    public void collectMetrics(Request<?> request, Response<?> response) {}
    
    public boolean isEnabled()
    {
      return false;
    }
  };
  
  public static abstract interface Factory
  {
    public abstract RequestMetricCollector getRequestMetricCollector();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
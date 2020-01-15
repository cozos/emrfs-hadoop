package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

final class MetricCollector$1
  extends MetricCollector
{
  public boolean start()
  {
    return true;
  }
  
  public boolean stop()
  {
    return true;
  }
  
  public boolean isEnabled()
  {
    return false;
  }
  
  public RequestMetricCollector getRequestMetricCollector()
  {
    return RequestMetricCollector.NONE;
  }
  
  public ServiceMetricCollector getServiceMetricCollector()
  {
    return ServiceMetricCollector.NONE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.MetricCollector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
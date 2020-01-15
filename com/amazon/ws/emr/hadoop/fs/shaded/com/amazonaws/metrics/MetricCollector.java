package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

public abstract class MetricCollector
{
  public static final MetricCollector NONE = new MetricCollector()
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
  };
  
  public abstract boolean start();
  
  public abstract boolean stop();
  
  public abstract boolean isEnabled();
  
  public abstract RequestMetricCollector getRequestMetricCollector();
  
  public abstract ServiceMetricCollector getServiceMetricCollector();
  
  public static abstract interface Factory
  {
    public abstract MetricCollector getInstance();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.MetricCollector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
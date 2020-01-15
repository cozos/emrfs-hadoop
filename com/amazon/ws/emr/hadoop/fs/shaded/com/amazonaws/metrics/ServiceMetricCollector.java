package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

public abstract class ServiceMetricCollector
{
  public abstract void collectByteThroughput(ByteThroughputProvider paramByteThroughputProvider);
  
  public abstract void collectLatency(ServiceLatencyProvider paramServiceLatencyProvider);
  
  public boolean isEnabled()
  {
    return true;
  }
  
  public static final ServiceMetricCollector NONE = new ServiceMetricCollector()
  {
    public void collectByteThroughput(ByteThroughputProvider provider) {}
    
    public void collectLatency(ServiceLatencyProvider provider) {}
    
    public boolean isEnabled()
    {
      return false;
    }
  };
  
  public static abstract interface Factory
  {
    public abstract ServiceMetricCollector getServiceMetricCollector();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ServiceMetricCollector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
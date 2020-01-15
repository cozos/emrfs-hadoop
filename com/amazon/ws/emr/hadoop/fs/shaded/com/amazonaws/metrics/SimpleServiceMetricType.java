package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

public class SimpleServiceMetricType
  extends SimpleMetricType
  implements ServiceMetricType
{
  private final String name;
  private final String serviceName;
  
  public SimpleServiceMetricType(String name, String serviceName)
  {
    this.name = name;
    this.serviceName = serviceName;
  }
  
  public String name()
  {
    return name;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.SimpleServiceMetricType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
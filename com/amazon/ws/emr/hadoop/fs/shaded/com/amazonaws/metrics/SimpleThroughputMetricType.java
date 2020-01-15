package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

public class SimpleThroughputMetricType
  extends SimpleServiceMetricType
  implements ThroughputMetricType
{
  private final ServiceMetricType byteCountMetricType;
  
  public SimpleThroughputMetricType(String name, String serviceName, String byteCountMetricName)
  {
    super(name, serviceName);
    byteCountMetricType = new SimpleServiceMetricType(byteCountMetricName, serviceName);
  }
  
  public ServiceMetricType getByteCountMetricType()
  {
    return byteCountMetricType;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.SimpleThroughputMetricType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
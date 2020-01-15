package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics;

public abstract class SimpleMetricType
  implements MetricType
{
  public abstract String name();
  
  public final int hashCode()
  {
    return name().hashCode();
  }
  
  public final boolean equals(Object o)
  {
    if (!(o instanceof MetricType)) {
      return false;
    }
    MetricType that = (MetricType)o;
    return name().equals(that.name());
  }
  
  public final String toString()
  {
    return name();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.SimpleMetricType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
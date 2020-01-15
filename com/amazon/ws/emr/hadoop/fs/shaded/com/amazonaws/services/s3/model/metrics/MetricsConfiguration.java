package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics;

import java.io.Serializable;

public class MetricsConfiguration
  implements Serializable
{
  private String id;
  private MetricsFilter filter;
  
  public String getId()
  {
    return id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public MetricsConfiguration withId(String id)
  {
    setId(id);
    return this;
  }
  
  public MetricsFilter getFilter()
  {
    return filter;
  }
  
  public void setFilter(MetricsFilter filter)
  {
    this.filter = filter;
  }
  
  public MetricsConfiguration withFilter(MetricsFilter filter)
  {
    setFilter(filter);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
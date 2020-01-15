package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics;

import java.io.Serializable;

public class MetricsFilter
  implements Serializable
{
  private MetricsFilterPredicate predicate;
  
  public MetricsFilter() {}
  
  public MetricsFilter(MetricsFilterPredicate predicate)
  {
    this.predicate = predicate;
  }
  
  public MetricsFilterPredicate getPredicate()
  {
    return predicate;
  }
  
  public void setPredicate(MetricsFilterPredicate predicate)
  {
    this.predicate = predicate;
  }
  
  public MetricsFilter withPredicate(MetricsFilterPredicate predicate)
  {
    setPredicate(predicate);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
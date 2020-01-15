package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public class AnalyticsFilter
  implements Serializable
{
  private AnalyticsFilterPredicate predicate;
  
  public AnalyticsFilter() {}
  
  public AnalyticsFilter(AnalyticsFilterPredicate predicate)
  {
    this.predicate = predicate;
  }
  
  public AnalyticsFilterPredicate getPredicate()
  {
    return predicate;
  }
  
  public void setPredicate(AnalyticsFilterPredicate predicate)
  {
    this.predicate = predicate;
  }
  
  public AnalyticsFilter withPredicate(AnalyticsFilterPredicate predicate)
  {
    setPredicate(predicate);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle;

import java.io.Serializable;

public class LifecycleFilter
  implements Serializable
{
  private LifecycleFilterPredicate predicate;
  
  public LifecycleFilter() {}
  
  public LifecycleFilter(LifecycleFilterPredicate predicate)
  {
    this.predicate = predicate;
  }
  
  public LifecycleFilterPredicate getPredicate()
  {
    return predicate;
  }
  
  public void setPredicate(LifecycleFilterPredicate predicate)
  {
    this.predicate = predicate;
  }
  
  public LifecycleFilter withPredicate(LifecycleFilterPredicate predicate)
  {
    setPredicate(predicate);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
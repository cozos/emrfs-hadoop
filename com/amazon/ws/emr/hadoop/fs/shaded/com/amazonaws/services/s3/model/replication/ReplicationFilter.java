package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication;

import java.io.Serializable;

public class ReplicationFilter
  implements Serializable
{
  private ReplicationFilterPredicate predicate;
  
  public ReplicationFilter() {}
  
  public ReplicationFilter(ReplicationFilterPredicate predicate)
  {
    this.predicate = predicate;
  }
  
  public ReplicationFilterPredicate getPredicate()
  {
    return predicate;
  }
  
  public void setPredicate(ReplicationFilterPredicate predicate)
  {
    this.predicate = predicate;
  }
  
  public ReplicationFilter withPredicate(ReplicationFilterPredicate predicate)
  {
    setPredicate(predicate);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication;

public final class ReplicationPrefixPredicate
  extends ReplicationFilterPredicate
{
  private final String prefix;
  
  public ReplicationPrefixPredicate(String prefix)
  {
    this.prefix = prefix;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public void accept(ReplicationPredicateVisitor replicationPredicateVisitor)
  {
    replicationPredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationPrefixPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication;

public abstract interface ReplicationPredicateVisitor
{
  public abstract void visit(ReplicationPrefixPredicate paramReplicationPrefixPredicate);
  
  public abstract void visit(ReplicationTagPredicate paramReplicationTagPredicate);
  
  public abstract void visit(ReplicationAndOperator paramReplicationAndOperator);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationPredicateVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
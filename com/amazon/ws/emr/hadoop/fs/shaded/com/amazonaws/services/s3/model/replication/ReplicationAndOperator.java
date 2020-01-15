package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication;

import java.util.List;

public final class ReplicationAndOperator
  extends ReplicationNAryOperator
{
  public ReplicationAndOperator(List<ReplicationFilterPredicate> operands)
  {
    super(operands);
  }
  
  public void accept(ReplicationPredicateVisitor replicationPredicateVisitor)
  {
    replicationPredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationAndOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
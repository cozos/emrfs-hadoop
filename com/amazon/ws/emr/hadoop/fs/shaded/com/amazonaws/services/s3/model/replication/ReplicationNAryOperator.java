package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication;

import java.util.List;

abstract class ReplicationNAryOperator
  extends ReplicationFilterPredicate
{
  private final List<ReplicationFilterPredicate> operands;
  
  public ReplicationNAryOperator(List<ReplicationFilterPredicate> operands)
  {
    this.operands = operands;
  }
  
  public List<ReplicationFilterPredicate> getOperands()
  {
    return operands;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationNAryOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
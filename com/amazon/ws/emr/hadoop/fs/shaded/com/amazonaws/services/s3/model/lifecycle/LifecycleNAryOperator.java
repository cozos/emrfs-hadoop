package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle;

import java.util.List;

abstract class LifecycleNAryOperator
  extends LifecycleFilterPredicate
{
  private final List<LifecycleFilterPredicate> operands;
  
  public LifecycleNAryOperator(List<LifecycleFilterPredicate> operands)
  {
    this.operands = operands;
  }
  
  public List<LifecycleFilterPredicate> getOperands()
  {
    return operands;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleNAryOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
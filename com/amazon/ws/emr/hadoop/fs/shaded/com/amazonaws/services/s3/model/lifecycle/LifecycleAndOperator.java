package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle;

import java.util.List;

public final class LifecycleAndOperator
  extends LifecycleNAryOperator
{
  public LifecycleAndOperator(List<LifecycleFilterPredicate> operands)
  {
    super(operands);
  }
  
  public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor)
  {
    lifecyclePredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
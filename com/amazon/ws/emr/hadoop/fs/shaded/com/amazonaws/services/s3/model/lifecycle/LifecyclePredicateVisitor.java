package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle;

public abstract interface LifecyclePredicateVisitor
{
  public abstract void visit(LifecyclePrefixPredicate paramLifecyclePrefixPredicate);
  
  public abstract void visit(LifecycleTagPredicate paramLifecycleTagPredicate);
  
  public abstract void visit(LifecycleAndOperator paramLifecycleAndOperator);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecyclePredicateVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
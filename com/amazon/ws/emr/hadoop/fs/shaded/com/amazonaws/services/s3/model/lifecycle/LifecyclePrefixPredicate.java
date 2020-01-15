package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle;

public final class LifecyclePrefixPredicate
  extends LifecycleFilterPredicate
{
  private final String prefix;
  
  public LifecyclePrefixPredicate(String prefix)
  {
    this.prefix = prefix;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor)
  {
    lifecyclePredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;

public final class LifecycleTagPredicate
  extends LifecycleFilterPredicate
{
  private final Tag tag;
  
  public LifecycleTagPredicate(Tag tag)
  {
    this.tag = tag;
  }
  
  public Tag getTag()
  {
    return tag;
  }
  
  public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor)
  {
    lifecyclePredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
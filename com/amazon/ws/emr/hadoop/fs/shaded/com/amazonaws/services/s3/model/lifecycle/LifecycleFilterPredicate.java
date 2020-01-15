package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle;

import java.io.Serializable;

public abstract class LifecycleFilterPredicate
  implements Serializable
{
  public abstract void accept(LifecyclePredicateVisitor paramLifecyclePredicateVisitor);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
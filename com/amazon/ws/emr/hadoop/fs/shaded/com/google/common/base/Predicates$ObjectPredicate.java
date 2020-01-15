package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import javax.annotation.Nullable;

 enum Predicates$ObjectPredicate
  implements Predicate<Object>
{
  ALWAYS_TRUE,  ALWAYS_FALSE,  IS_NULL,  NOT_NULL;
  
  private Predicates$ObjectPredicate() {}
  
  <T> Predicate<T> withNarrowedType()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.ObjectPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
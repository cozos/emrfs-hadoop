package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import javax.annotation.Nullable;

 enum Predicates$ObjectPredicate$3
{
  Predicates$ObjectPredicate$3()
  {
    super(paramString, paramInt, null);
  }
  
  public boolean apply(@Nullable Object o)
  {
    return o == null;
  }
  
  public String toString()
  {
    return "Predicates.isNull()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.ObjectPredicate.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
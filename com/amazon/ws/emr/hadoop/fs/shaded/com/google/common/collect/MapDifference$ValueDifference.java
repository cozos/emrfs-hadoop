package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

public abstract interface MapDifference$ValueDifference<V>
{
  public abstract V leftValue();
  
  public abstract V rightValue();
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapDifference.ValueDifference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
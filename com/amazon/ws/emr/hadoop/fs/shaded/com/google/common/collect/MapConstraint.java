package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
@Beta
public abstract interface MapConstraint<K, V>
{
  public abstract void checkKeyValue(@Nullable K paramK, @Nullable V paramV);
  
  public abstract String toString();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraint
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface Function<F, T>
{
  @Nullable
  public abstract T apply(@Nullable F paramF);
  
  public abstract boolean equals(@Nullable Object paramObject);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
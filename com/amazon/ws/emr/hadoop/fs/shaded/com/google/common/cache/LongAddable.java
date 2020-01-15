package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;

@GwtCompatible
abstract interface LongAddable
{
  public abstract void increment();
  
  public abstract void add(long paramLong);
  
  public abstract long sum();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LongAddable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
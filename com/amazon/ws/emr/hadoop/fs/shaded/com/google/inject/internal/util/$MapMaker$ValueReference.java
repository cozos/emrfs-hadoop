package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

abstract interface $MapMaker$ValueReference<K, V>
{
  public abstract V get();
  
  public abstract ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> paramReferenceEntry);
  
  public abstract V waitForValue()
    throws InterruptedException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.ValueReference
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
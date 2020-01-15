package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

abstract interface MapMakerInternalMap$ValueReference<K, V>
{
  public abstract V get();
  
  public abstract V waitForValue()
    throws ExecutionException;
  
  public abstract MapMakerInternalMap.ReferenceEntry<K, V> getEntry();
  
  public abstract ValueReference<K, V> copyFor(ReferenceQueue<V> paramReferenceQueue, @Nullable V paramV, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public abstract void clear(@Nullable ValueReference<K, V> paramValueReference);
  
  public abstract boolean isComputingReference();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.ValueReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
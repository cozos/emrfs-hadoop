package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

abstract interface LocalCache$ValueReference<K, V>
{
  @Nullable
  public abstract V get();
  
  public abstract V waitForValue()
    throws ExecutionException;
  
  public abstract int getWeight();
  
  @Nullable
  public abstract LocalCache.ReferenceEntry<K, V> getEntry();
  
  public abstract ValueReference<K, V> copyFor(ReferenceQueue<V> paramReferenceQueue, @Nullable V paramV, LocalCache.ReferenceEntry<K, V> paramReferenceEntry);
  
  public abstract void notifyNewValue(@Nullable V paramV);
  
  public abstract boolean isLoading();
  
  public abstract boolean isActive();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.ValueReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
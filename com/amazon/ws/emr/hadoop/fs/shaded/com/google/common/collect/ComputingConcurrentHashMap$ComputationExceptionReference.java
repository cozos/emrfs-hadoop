package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;

final class ComputingConcurrentHashMap$ComputationExceptionReference<K, V>
  implements MapMakerInternalMap.ValueReference<K, V>
{
  final Throwable t;
  
  ComputingConcurrentHashMap$ComputationExceptionReference(Throwable t)
  {
    this.t = t;
  }
  
  public V get()
  {
    return null;
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
  {
    return null;
  }
  
  public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    return this;
  }
  
  public boolean isComputingReference()
  {
    return false;
  }
  
  public V waitForValue()
    throws ExecutionException
  {
    throw new ExecutionException(t);
  }
  
  public void clear(MapMakerInternalMap.ValueReference<K, V> newValue) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ComputingConcurrentHashMap.ComputationExceptionReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
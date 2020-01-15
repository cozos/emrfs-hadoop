package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class ComputingConcurrentHashMap$ComputedReference<K, V>
  implements MapMakerInternalMap.ValueReference<K, V>
{
  final V value;
  
  ComputingConcurrentHashMap$ComputedReference(@Nullable V value)
  {
    this.value = value;
  }
  
  public V get()
  {
    return (V)value;
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
  {
    return (V)get();
  }
  
  public void clear(MapMakerInternalMap.ValueReference<K, V> newValue) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ComputingConcurrentHashMap.ComputedReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
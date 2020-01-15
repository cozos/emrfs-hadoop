package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class MapMakerInternalMap$WeakValueReference<K, V>
  extends WeakReference<V>
  implements MapMakerInternalMap.ValueReference<K, V>
{
  final MapMakerInternalMap.ReferenceEntry<K, V> entry;
  
  MapMakerInternalMap$WeakValueReference(ReferenceQueue<V> queue, V referent, MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    super(referent, queue);
    this.entry = entry;
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
  {
    return entry;
  }
  
  public void clear(MapMakerInternalMap.ValueReference<K, V> newValue)
  {
    clear();
  }
  
  public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    return new WeakValueReference(queue, value, entry);
  }
  
  public boolean isComputingReference()
  {
    return false;
  }
  
  public V waitForValue()
  {
    return (V)get();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.WeakValueReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

class MapMakerInternalMap$WeakEntry<K, V>
  extends WeakReference<K>
  implements MapMakerInternalMap.ReferenceEntry<K, V>
{
  final int hash;
  final MapMakerInternalMap.ReferenceEntry<K, V> next;
  
  MapMakerInternalMap$WeakEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    super(key, queue);
    this.hash = hash;
    this.next = next;
  }
  
  public K getKey()
  {
    return (K)get();
  }
  
  public long getExpirationTime()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setExpirationTime(long time)
  {
    throw new UnsupportedOperationException();
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    throw new UnsupportedOperationException();
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
  {
    throw new UnsupportedOperationException();
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    throw new UnsupportedOperationException();
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
  {
    throw new UnsupportedOperationException();
  }
  
  volatile MapMakerInternalMap.ValueReference<K, V> valueReference = MapMakerInternalMap.unset();
  
  public MapMakerInternalMap.ValueReference<K, V> getValueReference()
  {
    return valueReference;
  }
  
  public void setValueReference(MapMakerInternalMap.ValueReference<K, V> valueReference)
  {
    MapMakerInternalMap.ValueReference<K, V> previous = this.valueReference;
    this.valueReference = valueReference;
    previous.clear(valueReference);
  }
  
  public int getHash()
  {
    return hash;
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getNext()
  {
    return next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.WeakEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
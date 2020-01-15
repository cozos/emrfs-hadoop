package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class MapMakerInternalMap$WeakExpirableEntry<K, V>
  extends MapMakerInternalMap.WeakEntry<K, V>
  implements MapMakerInternalMap.ReferenceEntry<K, V>
{
  MapMakerInternalMap$WeakExpirableEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    super(queue, key, hash, next);
  }
  
  volatile long time = Long.MAX_VALUE;
  
  public long getExpirationTime()
  {
    return time;
  }
  
  public void setExpirationTime(long time)
  {
    this.time = time;
  }
  
  MapMakerInternalMap.ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
  {
    return nextExpirable;
  }
  
  public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    nextExpirable = next;
  }
  
  MapMakerInternalMap.ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
  {
    return previousExpirable;
  }
  
  public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
  {
    previousExpirable = previous;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.WeakExpirableEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
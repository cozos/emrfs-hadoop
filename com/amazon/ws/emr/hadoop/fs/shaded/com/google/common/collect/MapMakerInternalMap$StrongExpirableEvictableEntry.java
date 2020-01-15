package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

final class MapMakerInternalMap$StrongExpirableEvictableEntry<K, V>
  extends MapMakerInternalMap.StrongEntry<K, V>
  implements MapMakerInternalMap.ReferenceEntry<K, V>
{
  MapMakerInternalMap$StrongExpirableEvictableEntry(K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    super(key, hash, next);
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
  
  MapMakerInternalMap.ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
  {
    return nextEvictable;
  }
  
  public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    nextEvictable = next;
  }
  
  MapMakerInternalMap.ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
  {
    return previousEvictable;
  }
  
  public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
  {
    previousEvictable = previous;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.StrongExpirableEvictableEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
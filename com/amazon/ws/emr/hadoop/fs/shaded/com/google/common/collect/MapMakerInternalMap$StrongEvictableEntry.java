package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

final class MapMakerInternalMap$StrongEvictableEntry<K, V>
  extends MapMakerInternalMap.StrongEntry<K, V>
  implements MapMakerInternalMap.ReferenceEntry<K, V>
{
  MapMakerInternalMap$StrongEvictableEntry(K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    super(key, hash, next);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.StrongEvictableEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
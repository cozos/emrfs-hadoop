package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

 enum MapMakerInternalMap$EntryFactory$6
{
  MapMakerInternalMap$EntryFactory$6()
  {
    super(paramString, paramInt, null);
  }
  
  <K, V> MapMakerInternalMap.ReferenceEntry<K, V> newEntry(MapMakerInternalMap.Segment<K, V> segment, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    return new MapMakerInternalMap.WeakExpirableEntry(keyReferenceQueue, key, hash, next);
  }
  
  <K, V> MapMakerInternalMap.ReferenceEntry<K, V> copyEntry(MapMakerInternalMap.Segment<K, V> segment, MapMakerInternalMap.ReferenceEntry<K, V> original, MapMakerInternalMap.ReferenceEntry<K, V> newNext)
  {
    MapMakerInternalMap.ReferenceEntry<K, V> newEntry = super.copyEntry(segment, original, newNext);
    copyExpirableEntry(original, newEntry);
    return newEntry;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.EntryFactory.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
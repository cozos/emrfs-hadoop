package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

 enum MapMakerInternalMap$EntryFactory$5
{
  MapMakerInternalMap$EntryFactory$5()
  {
    super(paramString, paramInt, null);
  }
  
  <K, V> MapMakerInternalMap.ReferenceEntry<K, V> newEntry(MapMakerInternalMap.Segment<K, V> segment, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    return new MapMakerInternalMap.WeakEntry(keyReferenceQueue, key, hash, next);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.EntryFactory.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
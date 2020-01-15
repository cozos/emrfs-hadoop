package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

 enum MapMakerInternalMap$EntryFactory
{
  STRONG,  STRONG_EXPIRABLE,  STRONG_EVICTABLE,  STRONG_EXPIRABLE_EVICTABLE,  WEAK,  WEAK_EXPIRABLE,  WEAK_EVICTABLE,  WEAK_EXPIRABLE_EVICTABLE;
  
  static final int EXPIRABLE_MASK = 1;
  static final int EVICTABLE_MASK = 2;
  static final EntryFactory[][] factories = { { STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE }, new EntryFactory[0], { WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE } };
  
  private MapMakerInternalMap$EntryFactory() {}
  
  static EntryFactory getFactory(MapMakerInternalMap.Strength keyStrength, boolean expireAfterWrite, boolean evictsBySize)
  {
    int flags = (expireAfterWrite ? 1 : 0) | (evictsBySize ? 2 : 0);
    return factories[keyStrength.ordinal()][flags];
  }
  
  abstract <K, V> MapMakerInternalMap.ReferenceEntry<K, V> newEntry(MapMakerInternalMap.Segment<K, V> paramSegment, K paramK, int paramInt, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  <K, V> MapMakerInternalMap.ReferenceEntry<K, V> copyEntry(MapMakerInternalMap.Segment<K, V> segment, MapMakerInternalMap.ReferenceEntry<K, V> original, MapMakerInternalMap.ReferenceEntry<K, V> newNext)
  {
    return newEntry(segment, original.getKey(), original.getHash(), newNext);
  }
  
  <K, V> void copyExpirableEntry(MapMakerInternalMap.ReferenceEntry<K, V> original, MapMakerInternalMap.ReferenceEntry<K, V> newEntry)
  {
    newEntry.setExpirationTime(original.getExpirationTime());
    
    MapMakerInternalMap.connectExpirables(original.getPreviousExpirable(), newEntry);
    MapMakerInternalMap.connectExpirables(newEntry, original.getNextExpirable());
    
    MapMakerInternalMap.nullifyExpirable(original);
  }
  
  <K, V> void copyEvictableEntry(MapMakerInternalMap.ReferenceEntry<K, V> original, MapMakerInternalMap.ReferenceEntry<K, V> newEntry)
  {
    MapMakerInternalMap.connectEvictables(original.getPreviousEvictable(), newEntry);
    MapMakerInternalMap.connectEvictables(newEntry, original.getNextEvictable());
    
    MapMakerInternalMap.nullifyEvictable(original);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.EntryFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
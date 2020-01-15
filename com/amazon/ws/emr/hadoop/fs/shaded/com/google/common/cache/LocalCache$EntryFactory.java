package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import javax.annotation.Nullable;

 enum LocalCache$EntryFactory
{
  STRONG,  STRONG_ACCESS,  STRONG_WRITE,  STRONG_ACCESS_WRITE,  WEAK,  WEAK_ACCESS,  WEAK_WRITE,  WEAK_ACCESS_WRITE;
  
  static final int ACCESS_MASK = 1;
  static final int WRITE_MASK = 2;
  static final int WEAK_MASK = 4;
  static final EntryFactory[] factories = { STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE };
  
  private LocalCache$EntryFactory() {}
  
  static EntryFactory getFactory(LocalCache.Strength keyStrength, boolean usesAccessQueue, boolean usesWriteQueue)
  {
    int flags = (keyStrength == LocalCache.Strength.WEAK ? 4 : 0) | (usesAccessQueue ? 1 : 0) | (usesWriteQueue ? 2 : 0);
    
    return factories[flags];
  }
  
  abstract <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> paramSegment, K paramK, int paramInt, @Nullable LocalCache.ReferenceEntry<K, V> paramReferenceEntry);
  
  <K, V> LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.Segment<K, V> segment, LocalCache.ReferenceEntry<K, V> original, LocalCache.ReferenceEntry<K, V> newNext)
  {
    return newEntry(segment, original.getKey(), original.getHash(), newNext);
  }
  
  <K, V> void copyAccessEntry(LocalCache.ReferenceEntry<K, V> original, LocalCache.ReferenceEntry<K, V> newEntry)
  {
    newEntry.setAccessTime(original.getAccessTime());
    
    LocalCache.connectAccessOrder(original.getPreviousInAccessQueue(), newEntry);
    LocalCache.connectAccessOrder(newEntry, original.getNextInAccessQueue());
    
    LocalCache.nullifyAccessOrder(original);
  }
  
  <K, V> void copyWriteEntry(LocalCache.ReferenceEntry<K, V> original, LocalCache.ReferenceEntry<K, V> newEntry)
  {
    newEntry.setWriteTime(original.getWriteTime());
    
    LocalCache.connectWriteOrder(original.getPreviousInWriteQueue(), newEntry);
    LocalCache.connectWriteOrder(newEntry, original.getNextInWriteQueue());
    
    LocalCache.nullifyWriteOrder(original);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.EntryFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
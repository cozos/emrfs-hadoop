package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import javax.annotation.Nullable;

 enum LocalCache$EntryFactory$8
{
  LocalCache$EntryFactory$8()
  {
    super(paramString, paramInt, null);
  }
  
  <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> segment, K key, int hash, @Nullable LocalCache.ReferenceEntry<K, V> next)
  {
    return new LocalCache.WeakAccessWriteEntry(keyReferenceQueue, key, hash, next);
  }
  
  <K, V> LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.Segment<K, V> segment, LocalCache.ReferenceEntry<K, V> original, LocalCache.ReferenceEntry<K, V> newNext)
  {
    LocalCache.ReferenceEntry<K, V> newEntry = super.copyEntry(segment, original, newNext);
    copyAccessEntry(original, newEntry);
    copyWriteEntry(original, newEntry);
    return newEntry;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.EntryFactory.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
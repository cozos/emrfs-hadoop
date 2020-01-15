package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import javax.annotation.Nullable;

 enum LocalCache$EntryFactory$5
{
  LocalCache$EntryFactory$5()
  {
    super(paramString, paramInt, null);
  }
  
  <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> segment, K key, int hash, @Nullable LocalCache.ReferenceEntry<K, V> next)
  {
    return new LocalCache.WeakEntry(keyReferenceQueue, key, hash, next);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.EntryFactory.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
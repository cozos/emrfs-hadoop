package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.util.Map.Entry;

final class LocalCache$EntryIterator
  extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>>
{
  LocalCache$EntryIterator(LocalCache paramLocalCache)
  {
    super(paramLocalCache);
  }
  
  public Map.Entry<K, V> next()
  {
    return nextEntry();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.EntryIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
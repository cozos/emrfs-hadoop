package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

final class LocalCache$KeyIterator
  extends LocalCache<K, V>.HashIterator<K>
{
  LocalCache$KeyIterator(LocalCache paramLocalCache)
  {
    super(paramLocalCache);
  }
  
  public K next()
  {
    return (K)nextEntry().getKey();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.KeyIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
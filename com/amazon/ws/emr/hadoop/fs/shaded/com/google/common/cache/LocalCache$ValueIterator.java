package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

final class LocalCache$ValueIterator
  extends LocalCache<K, V>.HashIterator<V>
{
  LocalCache$ValueIterator(LocalCache paramLocalCache)
  {
    super(paramLocalCache);
  }
  
  public V next()
  {
    return (V)nextEntry().getValue();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.ValueIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
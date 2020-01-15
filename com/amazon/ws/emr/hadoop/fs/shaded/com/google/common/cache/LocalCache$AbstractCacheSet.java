package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.util.AbstractSet;
import java.util.concurrent.ConcurrentMap;

abstract class LocalCache$AbstractCacheSet<T>
  extends AbstractSet<T>
{
  final ConcurrentMap<?, ?> map;
  
  LocalCache$AbstractCacheSet(ConcurrentMap<?, ?> arg1)
  {
    this.map = map;
  }
  
  public int size()
  {
    return map.size();
  }
  
  public boolean isEmpty()
  {
    return map.isEmpty();
  }
  
  public void clear()
  {
    map.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.AbstractCacheSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
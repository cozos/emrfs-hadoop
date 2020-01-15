package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

final class LocalCache$KeySet
  extends LocalCache<K, V>.AbstractCacheSet<K>
{
  LocalCache$KeySet(ConcurrentMap<?, ?> arg1)
  {
    super(???, map);
  }
  
  public Iterator<K> iterator()
  {
    return new LocalCache.KeyIterator(this$0);
  }
  
  public boolean contains(Object o)
  {
    return map.containsKey(o);
  }
  
  public boolean remove(Object o)
  {
    return map.remove(o) != null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.KeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
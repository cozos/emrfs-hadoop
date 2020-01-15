package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

final class LocalCache$EntrySet
  extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>>
{
  LocalCache$EntrySet(ConcurrentMap<?, ?> arg1)
  {
    super(???, map);
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new LocalCache.EntryIterator(this$0);
  }
  
  public boolean contains(Object o)
  {
    if (!(o instanceof Map.Entry)) {
      return false;
    }
    Map.Entry<?, ?> e = (Map.Entry)o;
    Object key = e.getKey();
    if (key == null) {
      return false;
    }
    V v = this$0.get(key);
    
    return (v != null) && (this$0.valueEquivalence.equivalent(e.getValue(), v));
  }
  
  public boolean remove(Object o)
  {
    if (!(o instanceof Map.Entry)) {
      return false;
    }
    Map.Entry<?, ?> e = (Map.Entry)o;
    Object key = e.getKey();
    return (key != null) && (this$0.remove(key, e.getValue()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
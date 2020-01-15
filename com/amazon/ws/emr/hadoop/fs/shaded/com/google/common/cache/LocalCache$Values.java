package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

final class LocalCache$Values
  extends AbstractCollection<V>
{
  private final ConcurrentMap<?, ?> map;
  
  LocalCache$Values(ConcurrentMap<?, ?> arg1)
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
  
  public Iterator<V> iterator()
  {
    return new LocalCache.ValueIterator(this$0);
  }
  
  public boolean contains(Object o)
  {
    return map.containsValue(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.Values
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
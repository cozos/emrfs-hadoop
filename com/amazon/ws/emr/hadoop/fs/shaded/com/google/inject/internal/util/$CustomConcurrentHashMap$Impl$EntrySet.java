package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class $CustomConcurrentHashMap$Impl$EntrySet
  extends AbstractSet<Map.Entry<K, V>>
{
  $CustomConcurrentHashMap$Impl$EntrySet(.CustomConcurrentHashMap.Impl paramImpl) {}
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new .CustomConcurrentHashMap.Impl.EntryIterator(this$0);
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
    
    return (v != null) && (this$0.strategy.equalValues(v, e.getValue()));
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
  
  public int size()
  {
    return this$0.size();
  }
  
  public boolean isEmpty()
  {
    return this$0.isEmpty();
  }
  
  public void clear()
  {
    this$0.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Impl.EntrySet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
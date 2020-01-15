package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class MapMakerInternalMap$EntrySet
  extends AbstractSet<Map.Entry<K, V>>
{
  MapMakerInternalMap$EntrySet(MapMakerInternalMap paramMapMakerInternalMap) {}
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new MapMakerInternalMap.EntryIterator(this$0);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
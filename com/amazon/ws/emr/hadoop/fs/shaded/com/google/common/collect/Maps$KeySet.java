package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Maps$KeySet<K, V>
  extends Sets.ImprovedAbstractSet<K>
{
  final Map<K, V> map;
  
  Maps$KeySet(Map<K, V> map)
  {
    this.map = ((Map)Preconditions.checkNotNull(map));
  }
  
  Map<K, V> map()
  {
    return map;
  }
  
  public Iterator<K> iterator()
  {
    return Maps.keyIterator(map().entrySet().iterator());
  }
  
  public int size()
  {
    return map().size();
  }
  
  public boolean isEmpty()
  {
    return map().isEmpty();
  }
  
  public boolean contains(Object o)
  {
    return map().containsKey(o);
  }
  
  public boolean remove(Object o)
  {
    if (contains(o))
    {
      map().remove(o);
      return true;
    }
    return false;
  }
  
  public void clear()
  {
    map().clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.KeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
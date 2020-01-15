package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$Values<K, V>
  extends AbstractCollection<V>
{
  final Map<K, V> map;
  
  Maps$Values(Map<K, V> map)
  {
    this.map = ((Map)Preconditions.checkNotNull(map));
  }
  
  final Map<K, V> map()
  {
    return map;
  }
  
  public Iterator<V> iterator()
  {
    return Maps.valueIterator(map().entrySet().iterator());
  }
  
  public boolean remove(Object o)
  {
    try
    {
      return super.remove(o);
    }
    catch (UnsupportedOperationException e)
    {
      for (Map.Entry<K, V> entry : map().entrySet()) {
        if (Objects.equal(o, entry.getValue()))
        {
          map().remove(entry.getKey());
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> c)
  {
    try
    {
      return super.removeAll((Collection)Preconditions.checkNotNull(c));
    }
    catch (UnsupportedOperationException e)
    {
      Set<K> toRemove = Sets.newHashSet();
      for (Map.Entry<K, V> entry : map().entrySet()) {
        if (c.contains(entry.getValue())) {
          toRemove.add(entry.getKey());
        }
      }
      return map().keySet().removeAll(toRemove);
    }
  }
  
  public boolean retainAll(Collection<?> c)
  {
    try
    {
      return super.retainAll((Collection)Preconditions.checkNotNull(c));
    }
    catch (UnsupportedOperationException e)
    {
      Set<K> toRetain = Sets.newHashSet();
      for (Map.Entry<K, V> entry : map().entrySet()) {
        if (c.contains(entry.getValue())) {
          toRetain.add(entry.getKey());
        }
      }
      return map().keySet().retainAll(toRetain);
    }
  }
  
  public int size()
  {
    return map().size();
  }
  
  public boolean isEmpty()
  {
    return map().isEmpty();
  }
  
  public boolean contains(@Nullable Object o)
  {
    return map().containsValue(o);
  }
  
  public void clear()
  {
    map().clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.Values
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
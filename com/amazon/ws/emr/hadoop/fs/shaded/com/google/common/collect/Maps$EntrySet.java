package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class Maps$EntrySet<K, V>
  extends Sets.ImprovedAbstractSet<Map.Entry<K, V>>
{
  abstract Map<K, V> map();
  
  public int size()
  {
    return map().size();
  }
  
  public void clear()
  {
    map().clear();
  }
  
  public boolean contains(Object o)
  {
    if ((o instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)o;
      Object key = entry.getKey();
      V value = Maps.safeGet(map(), key);
      return (Objects.equal(value, entry.getValue())) && ((value != null) || (map().containsKey(key)));
    }
    return false;
  }
  
  public boolean isEmpty()
  {
    return map().isEmpty();
  }
  
  public boolean remove(Object o)
  {
    if (contains(o))
    {
      Map.Entry<?, ?> entry = (Map.Entry)o;
      return map().keySet().remove(entry.getKey());
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> c)
  {
    try
    {
      return super.removeAll((Collection)Preconditions.checkNotNull(c));
    }
    catch (UnsupportedOperationException e) {}
    return Sets.removeAllImpl(this, c.iterator());
  }
  
  public boolean retainAll(Collection<?> c)
  {
    try
    {
      return super.retainAll((Collection)Preconditions.checkNotNull(c));
    }
    catch (UnsupportedOperationException e)
    {
      Set<Object> keys = Sets.newHashSetWithExpectedSize(c.size());
      for (Object o : c) {
        if (contains(o))
        {
          Map.Entry<?, ?> entry = (Map.Entry)o;
          keys.add(entry.getKey());
        }
      }
      return map().keySet().retainAll(keys);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
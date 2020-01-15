package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

class Multimaps$MapMultimap<K, V>
  extends AbstractMultimap<K, V>
  implements SetMultimap<K, V>, Serializable
{
  final Map<K, V> map;
  private static final long serialVersionUID = 7845222491160860175L;
  
  Multimaps$MapMultimap(Map<K, V> map)
  {
    this.map = ((Map)Preconditions.checkNotNull(map));
  }
  
  public int size()
  {
    return map.size();
  }
  
  public boolean containsKey(Object key)
  {
    return map.containsKey(key);
  }
  
  public boolean containsValue(Object value)
  {
    return map.containsValue(value);
  }
  
  public boolean containsEntry(Object key, Object value)
  {
    return map.entrySet().contains(Maps.immutableEntry(key, value));
  }
  
  public Set<V> get(final K key)
  {
    new Sets.ImprovedAbstractSet()
    {
      public Iterator<V> iterator()
      {
        new Iterator()
        {
          int i;
          
          public boolean hasNext()
          {
            return (i == 0) && (map.containsKey(val$key));
          }
          
          public V next()
          {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            i += 1;
            return (V)map.get(val$key);
          }
          
          public void remove()
          {
            CollectPreconditions.checkRemove(i == 1);
            i = -1;
            map.remove(val$key);
          }
        };
      }
      
      public int size()
      {
        return map.containsKey(key) ? 1 : 0;
      }
    };
  }
  
  public boolean put(K key, V value)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean putAll(K key, Iterable<? extends V> values)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean putAll(Multimap<? extends K, ? extends V> multimap)
  {
    throw new UnsupportedOperationException();
  }
  
  public Set<V> replaceValues(K key, Iterable<? extends V> values)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean remove(Object key, Object value)
  {
    return map.entrySet().remove(Maps.immutableEntry(key, value));
  }
  
  public Set<V> removeAll(Object key)
  {
    Set<V> values = new HashSet(2);
    if (!map.containsKey(key)) {
      return values;
    }
    values.add(map.remove(key));
    return values;
  }
  
  public void clear()
  {
    map.clear();
  }
  
  public Set<K> keySet()
  {
    return map.keySet();
  }
  
  public Collection<V> values()
  {
    return map.values();
  }
  
  public Set<Map.Entry<K, V>> entries()
  {
    return map.entrySet();
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    return map.entrySet().iterator();
  }
  
  Map<K, Collection<V>> createAsMap()
  {
    return new Multimaps.AsMap(this);
  }
  
  public int hashCode()
  {
    return map.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.MapMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
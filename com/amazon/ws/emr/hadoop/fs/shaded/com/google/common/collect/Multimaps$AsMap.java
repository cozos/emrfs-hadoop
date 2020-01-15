package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class Multimaps$AsMap<K, V>
  extends Maps.ImprovedAbstractMap<K, Collection<V>>
{
  private final Multimap<K, V> multimap;
  
  Multimaps$AsMap(Multimap<K, V> multimap)
  {
    this.multimap = ((Multimap)Preconditions.checkNotNull(multimap));
  }
  
  public int size()
  {
    return multimap.keySet().size();
  }
  
  protected Set<Map.Entry<K, Collection<V>>> createEntrySet()
  {
    return new EntrySet();
  }
  
  void removeValuesForKey(Object key)
  {
    multimap.keySet().remove(key);
  }
  
  class EntrySet
    extends Maps.EntrySet<K, Collection<V>>
  {
    EntrySet() {}
    
    Map<K, Collection<V>> map()
    {
      return Multimaps.AsMap.this;
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator()
    {
      Maps.asMapEntryIterator(multimap.keySet(), new Function()
      {
        public Collection<V> apply(K key)
        {
          return multimap.get(key);
        }
      });
    }
    
    public boolean remove(Object o)
    {
      if (!contains(o)) {
        return false;
      }
      Map.Entry<?, ?> entry = (Map.Entry)o;
      removeValuesForKey(entry.getKey());
      return true;
    }
  }
  
  public Collection<V> get(Object key)
  {
    return containsKey(key) ? multimap.get(key) : null;
  }
  
  public Collection<V> remove(Object key)
  {
    return containsKey(key) ? multimap.removeAll(key) : null;
  }
  
  public Set<K> keySet()
  {
    return multimap.keySet();
  }
  
  public boolean isEmpty()
  {
    return multimap.isEmpty();
  }
  
  public boolean containsKey(Object key)
  {
    return multimap.containsKey(key);
  }
  
  public void clear()
  {
    multimap.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.AsMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
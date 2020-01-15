package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Multimaps$Keys<K, V>
  extends AbstractMultiset<K>
{
  final Multimap<K, V> multimap;
  
  Multimaps$Keys(Multimap<K, V> multimap)
  {
    this.multimap = multimap;
  }
  
  Iterator<Multiset.Entry<K>> entryIterator()
  {
    new TransformedIterator(multimap.asMap().entrySet().iterator())
    {
      Multiset.Entry<K> transform(final Map.Entry<K, Collection<V>> backingEntry)
      {
        new Multisets.AbstractEntry()
        {
          public K getElement()
          {
            return (K)backingEntry.getKey();
          }
          
          public int getCount()
          {
            return ((Collection)backingEntry.getValue()).size();
          }
        };
      }
    };
  }
  
  int distinctElements()
  {
    return multimap.asMap().size();
  }
  
  Set<Multiset.Entry<K>> createEntrySet()
  {
    return new KeysEntrySet();
  }
  
  class KeysEntrySet
    extends Multisets.EntrySet<K>
  {
    KeysEntrySet() {}
    
    Multiset<K> multiset()
    {
      return Multimaps.Keys.this;
    }
    
    public Iterator<Multiset.Entry<K>> iterator()
    {
      return entryIterator();
    }
    
    public int size()
    {
      return distinctElements();
    }
    
    public boolean isEmpty()
    {
      return multimap.isEmpty();
    }
    
    public boolean contains(@Nullable Object o)
    {
      if ((o instanceof Multiset.Entry))
      {
        Multiset.Entry<?> entry = (Multiset.Entry)o;
        Collection<V> collection = (Collection)multimap.asMap().get(entry.getElement());
        return (collection != null) && (collection.size() == entry.getCount());
      }
      return false;
    }
    
    public boolean remove(@Nullable Object o)
    {
      if ((o instanceof Multiset.Entry))
      {
        Multiset.Entry<?> entry = (Multiset.Entry)o;
        Collection<V> collection = (Collection)multimap.asMap().get(entry.getElement());
        if ((collection != null) && (collection.size() == entry.getCount()))
        {
          collection.clear();
          return true;
        }
      }
      return false;
    }
  }
  
  public boolean contains(@Nullable Object element)
  {
    return multimap.containsKey(element);
  }
  
  public Iterator<K> iterator()
  {
    return Maps.keyIterator(multimap.entries().iterator());
  }
  
  public int count(@Nullable Object element)
  {
    Collection<V> values = (Collection)Maps.safeGet(multimap.asMap(), element);
    return values == null ? 0 : values.size();
  }
  
  public int remove(@Nullable Object element, int occurrences)
  {
    CollectPreconditions.checkNonnegative(occurrences, "occurrences");
    if (occurrences == 0) {
      return count(element);
    }
    Collection<V> values = (Collection)Maps.safeGet(multimap.asMap(), element);
    if (values == null) {
      return 0;
    }
    int oldCount = values.size();
    if (occurrences >= oldCount)
    {
      values.clear();
    }
    else
    {
      Iterator<V> iterator = values.iterator();
      for (int i = 0; i < occurrences; i++)
      {
        iterator.next();
        iterator.remove();
      }
    }
    return oldCount;
  }
  
  public void clear()
  {
    multimap.clear();
  }
  
  public Set<K> elementSet()
  {
    return multimap.keySet();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.Keys
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
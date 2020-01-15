package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Maps$FilteredEntryMap<K, V>
  extends Maps.AbstractFilteredMap<K, V>
{
  final Set<Map.Entry<K, V>> filteredEntrySet;
  
  Maps$FilteredEntryMap(Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    super(unfiltered, entryPredicate);
    filteredEntrySet = Sets.filter(unfiltered.entrySet(), predicate);
  }
  
  protected Set<Map.Entry<K, V>> createEntrySet()
  {
    return new EntrySet(null);
  }
  
  private class EntrySet
    extends ForwardingSet<Map.Entry<K, V>>
  {
    private EntrySet() {}
    
    protected Set<Map.Entry<K, V>> delegate()
    {
      return filteredEntrySet;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      new TransformedIterator(filteredEntrySet.iterator())
      {
        Map.Entry<K, V> transform(final Map.Entry<K, V> entry)
        {
          new ForwardingMapEntry()
          {
            protected Map.Entry<K, V> delegate()
            {
              return entry;
            }
            
            public V setValue(V newValue)
            {
              Preconditions.checkArgument(apply(getKey(), newValue));
              return (V)super.setValue(newValue);
            }
          };
        }
      };
    }
  }
  
  Set<K> createKeySet()
  {
    return new KeySet();
  }
  
  class KeySet
    extends Maps.KeySet<K, V>
  {
    KeySet()
    {
      super();
    }
    
    public boolean remove(Object o)
    {
      if (containsKey(o))
      {
        unfiltered.remove(o);
        return true;
      }
      return false;
    }
    
    private boolean removeIf(Predicate<? super K> keyPredicate)
    {
      return Iterables.removeIf(unfiltered.entrySet(), Predicates.and(predicate, Maps.keyPredicateOnEntries(keyPredicate)));
    }
    
    public boolean removeAll(Collection<?> c)
    {
      return removeIf(Predicates.in(c));
    }
    
    public boolean retainAll(Collection<?> c)
    {
      return removeIf(Predicates.not(Predicates.in(c)));
    }
    
    public Object[] toArray()
    {
      return Lists.newArrayList(iterator()).toArray();
    }
    
    public <T> T[] toArray(T[] array)
    {
      return Lists.newArrayList(iterator()).toArray(array);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.FilteredEntryMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
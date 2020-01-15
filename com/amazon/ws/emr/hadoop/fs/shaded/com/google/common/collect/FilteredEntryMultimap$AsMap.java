package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredEntryMultimap$AsMap
  extends Maps.ImprovedAbstractMap<K, Collection<V>>
{
  FilteredEntryMultimap$AsMap(FilteredEntryMultimap paramFilteredEntryMultimap) {}
  
  public boolean containsKey(@Nullable Object key)
  {
    return get(key) != null;
  }
  
  public void clear()
  {
    this$0.clear();
  }
  
  public Collection<V> get(@Nullable Object key)
  {
    Collection<V> result = (Collection)this$0.unfiltered.asMap().get(key);
    if (result == null) {
      return null;
    }
    K k = (K)key;
    result = FilteredEntryMultimap.filterCollection(result, new FilteredEntryMultimap.ValuePredicate(this$0, k));
    return result.isEmpty() ? null : result;
  }
  
  public Collection<V> remove(@Nullable Object key)
  {
    Collection<V> collection = (Collection)this$0.unfiltered.asMap().get(key);
    if (collection == null) {
      return null;
    }
    K k = (K)key;
    List<V> result = Lists.newArrayList();
    Iterator<V> itr = collection.iterator();
    while (itr.hasNext())
    {
      V v = itr.next();
      if (FilteredEntryMultimap.access$000(this$0, k, v))
      {
        itr.remove();
        result.add(v);
      }
    }
    if (result.isEmpty()) {
      return null;
    }
    if ((this$0.unfiltered instanceof SetMultimap)) {
      return Collections.unmodifiableSet(Sets.newLinkedHashSet(result));
    }
    return Collections.unmodifiableList(result);
  }
  
  Set<K> createKeySet()
  {
    new Maps.KeySet(this)
    {
      public boolean removeAll(Collection<?> c)
      {
        return this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(c)));
      }
      
      public boolean retainAll(Collection<?> c)
      {
        return this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(c))));
      }
      
      public boolean remove(@Nullable Object o)
      {
        return remove(o) != null;
      }
    };
  }
  
  Set<Map.Entry<K, Collection<V>>> createEntrySet()
  {
    new Maps.EntrySet()
    {
      Map<K, Collection<V>> map()
      {
        return FilteredEntryMultimap.AsMap.this;
      }
      
      public Iterator<Map.Entry<K, Collection<V>>> iterator()
      {
        new AbstractIterator()
        {
          final Iterator<Map.Entry<K, Collection<V>>> backingIterator = this$0.unfiltered.asMap().entrySet().iterator();
          
          protected Map.Entry<K, Collection<V>> computeNext()
          {
            while (backingIterator.hasNext())
            {
              Map.Entry<K, Collection<V>> entry = (Map.Entry)backingIterator.next();
              K key = entry.getKey();
              Collection<V> collection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate(this$0, key));
              if (!collection.isEmpty()) {
                return Maps.immutableEntry(key, collection);
              }
            }
            return (Map.Entry)endOfData();
          }
        };
      }
      
      public boolean removeAll(Collection<?> c)
      {
        return this$0.removeEntriesIf(Predicates.in(c));
      }
      
      public boolean retainAll(Collection<?> c)
      {
        return this$0.removeEntriesIf(Predicates.not(Predicates.in(c)));
      }
      
      public int size()
      {
        return Iterators.size(iterator());
      }
    };
  }
  
  Collection<Collection<V>> createValues()
  {
    new Maps.Values(this)
    {
      public boolean remove(@Nullable Object o)
      {
        if ((o instanceof Collection))
        {
          Collection<?> c = (Collection)o;
          Iterator<Map.Entry<K, Collection<V>>> entryIterator = this$0.unfiltered.asMap().entrySet().iterator();
          while (entryIterator.hasNext())
          {
            Map.Entry<K, Collection<V>> entry = (Map.Entry)entryIterator.next();
            K key = entry.getKey();
            Collection<V> collection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate(this$0, key));
            if ((!collection.isEmpty()) && (c.equals(collection)))
            {
              if (collection.size() == ((Collection)entry.getValue()).size()) {
                entryIterator.remove();
              } else {
                collection.clear();
              }
              return true;
            }
          }
        }
        return false;
      }
      
      public boolean removeAll(Collection<?> c)
      {
        return this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(c)));
      }
      
      public boolean retainAll(Collection<?> c)
      {
        return this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(c))));
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredEntryMultimap.AsMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
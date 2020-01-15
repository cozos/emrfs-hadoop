package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredEntryMultimap$Keys
  extends Multimaps.Keys<K, V>
{
  FilteredEntryMultimap$Keys(FilteredEntryMultimap paramFilteredEntryMultimap)
  {
    super(paramFilteredEntryMultimap);
  }
  
  public int remove(@Nullable Object key, int occurrences)
  {
    CollectPreconditions.checkNonnegative(occurrences, "occurrences");
    if (occurrences == 0) {
      return count(key);
    }
    Collection<V> collection = (Collection)this$0.unfiltered.asMap().get(key);
    if (collection == null) {
      return 0;
    }
    K k = (K)key;
    int oldCount = 0;
    Iterator<V> itr = collection.iterator();
    while (itr.hasNext())
    {
      V v = itr.next();
      if (FilteredEntryMultimap.access$000(this$0, k, v))
      {
        oldCount++;
        if (oldCount <= occurrences) {
          itr.remove();
        }
      }
    }
    return oldCount;
  }
  
  public Set<Multiset.Entry<K>> entrySet()
  {
    new Multisets.EntrySet()
    {
      Multiset<K> multiset()
      {
        return FilteredEntryMultimap.Keys.this;
      }
      
      public Iterator<Multiset.Entry<K>> iterator()
      {
        return entryIterator();
      }
      
      public int size()
      {
        return this$0.keySet().size();
      }
      
      private boolean removeEntriesIf(final Predicate<? super Multiset.Entry<K>> predicate)
      {
        this$0.removeEntriesIf(new Predicate()
        {
          public boolean apply(Map.Entry<K, Collection<V>> entry)
          {
            return predicate.apply(Multisets.immutableEntry(entry.getKey(), ((Collection)entry.getValue()).size()));
          }
        });
      }
      
      public boolean removeAll(Collection<?> c)
      {
        return removeEntriesIf(Predicates.in(c));
      }
      
      public boolean retainAll(Collection<?> c)
      {
        return removeEntriesIf(Predicates.not(Predicates.in(c)));
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredEntryMultimap.Keys
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
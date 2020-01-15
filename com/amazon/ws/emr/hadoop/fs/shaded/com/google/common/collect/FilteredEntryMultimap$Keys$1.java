package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class FilteredEntryMultimap$Keys$1
  extends Multisets.EntrySet<K>
{
  FilteredEntryMultimap$Keys$1(FilteredEntryMultimap.Keys paramKeys) {}
  
  Multiset<K> multiset()
  {
    return this$1;
  }
  
  public Iterator<Multiset.Entry<K>> iterator()
  {
    return this$1.entryIterator();
  }
  
  public int size()
  {
    return this$1.this$0.keySet().size();
  }
  
  private boolean removeEntriesIf(final Predicate<? super Multiset.Entry<K>> predicate)
  {
    this$1.this$0.removeEntriesIf(new Predicate()
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredEntryMultimap.Keys.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
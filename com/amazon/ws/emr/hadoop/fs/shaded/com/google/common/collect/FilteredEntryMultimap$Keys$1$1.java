package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map.Entry;

class FilteredEntryMultimap$Keys$1$1
  implements Predicate<Map.Entry<K, Collection<V>>>
{
  FilteredEntryMultimap$Keys$1$1(FilteredEntryMultimap.Keys.1 param1, Predicate paramPredicate) {}
  
  public boolean apply(Map.Entry<K, Collection<V>> entry)
  {
    return val$predicate.apply(Multisets.immutableEntry(entry.getKey(), ((Collection)entry.getValue()).size()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredEntryMultimap.Keys.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.NavigableMap;
import java.util.Set;

class Maps$FilteredEntryNavigableMap$1
  extends Maps.NavigableKeySet<K, V>
{
  Maps$FilteredEntryNavigableMap$1(Maps.FilteredEntryNavigableMap paramFilteredEntryNavigableMap, NavigableMap x0)
  {
    super(x0);
  }
  
  public boolean removeAll(Collection<?> c)
  {
    return Iterators.removeIf(Maps.FilteredEntryNavigableMap.access$700(this$0).entrySet().iterator(), Predicates.and(Maps.FilteredEntryNavigableMap.access$600(this$0), Maps.keyPredicateOnEntries(Predicates.in(c))));
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return Iterators.removeIf(Maps.FilteredEntryNavigableMap.access$700(this$0).entrySet().iterator(), Predicates.and(Maps.FilteredEntryNavigableMap.access$600(this$0), Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(c)))));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.FilteredEntryNavigableMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
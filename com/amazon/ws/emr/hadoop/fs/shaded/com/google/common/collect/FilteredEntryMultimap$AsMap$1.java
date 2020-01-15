package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;

class FilteredEntryMultimap$AsMap$1
  extends Maps.KeySet<K, Collection<V>>
{
  FilteredEntryMultimap$AsMap$1(FilteredEntryMultimap.AsMap paramAsMap, Map x0)
  {
    super(x0);
  }
  
  public boolean removeAll(Collection<?> c)
  {
    return this$1.this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(c)));
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return this$1.this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(c))));
  }
  
  public boolean remove(@Nullable Object o)
  {
    return this$1.remove(o) != null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredEntryMultimap.AsMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
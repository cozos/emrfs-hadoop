package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredEntryMultimap$AsMap$3
  extends Maps.Values<K, Collection<V>>
{
  FilteredEntryMultimap$AsMap$3(FilteredEntryMultimap.AsMap paramAsMap, Map x0)
  {
    super(x0);
  }
  
  public boolean remove(@Nullable Object o)
  {
    if ((o instanceof Collection))
    {
      Collection<?> c = (Collection)o;
      Iterator<Map.Entry<K, Collection<V>>> entryIterator = this$1.this$0.unfiltered.asMap().entrySet().iterator();
      while (entryIterator.hasNext())
      {
        Map.Entry<K, Collection<V>> entry = (Map.Entry)entryIterator.next();
        K key = entry.getKey();
        Collection<V> collection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate(this$1.this$0, key));
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
    return this$1.this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(c)));
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return this$1.this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(c))));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredEntryMultimap.AsMap.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class FilteredEntryMultimap$AsMap$2
  extends Maps.EntrySet<K, Collection<V>>
{
  FilteredEntryMultimap$AsMap$2(FilteredEntryMultimap.AsMap paramAsMap) {}
  
  Map<K, Collection<V>> map()
  {
    return this$1;
  }
  
  public Iterator<Map.Entry<K, Collection<V>>> iterator()
  {
    new AbstractIterator()
    {
      final Iterator<Map.Entry<K, Collection<V>>> backingIterator = this$1.this$0.unfiltered.asMap().entrySet().iterator();
      
      protected Map.Entry<K, Collection<V>> computeNext()
      {
        while (backingIterator.hasNext())
        {
          Map.Entry<K, Collection<V>> entry = (Map.Entry)backingIterator.next();
          K key = entry.getKey();
          Collection<V> collection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap.ValuePredicate(this$1.this$0, key));
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
    return this$1.this$0.removeEntriesIf(Predicates.in(c));
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return this$1.this$0.removeEntriesIf(Predicates.not(Predicates.in(c)));
  }
  
  public int size()
  {
    return Iterators.size(iterator());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredEntryMultimap.AsMap.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
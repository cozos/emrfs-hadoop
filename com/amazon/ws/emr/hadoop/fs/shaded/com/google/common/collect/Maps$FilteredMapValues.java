package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

final class Maps$FilteredMapValues<K, V>
  extends Maps.Values<K, V>
{
  Map<K, V> unfiltered;
  Predicate<? super Map.Entry<K, V>> predicate;
  
  Maps$FilteredMapValues(Map<K, V> filteredMap, Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> predicate)
  {
    super(filteredMap);
    this.unfiltered = unfiltered;
    this.predicate = predicate;
  }
  
  public boolean remove(Object o)
  {
    return Iterables.removeFirstMatching(unfiltered.entrySet(), Predicates.and(predicate, Maps.valuePredicateOnEntries(Predicates.equalTo(o)))) != null;
  }
  
  private boolean removeIf(Predicate<? super V> valuePredicate)
  {
    return Iterables.removeIf(unfiltered.entrySet(), Predicates.and(predicate, Maps.valuePredicateOnEntries(valuePredicate)));
  }
  
  public boolean removeAll(Collection<?> collection)
  {
    return removeIf(Predicates.in(collection));
  }
  
  public boolean retainAll(Collection<?> collection)
  {
    return removeIf(Predicates.not(Predicates.in(collection)));
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.FilteredMapValues
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
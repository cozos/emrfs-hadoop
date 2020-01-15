package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

class Maps$FilteredEntryMap$KeySet
  extends Maps.KeySet<K, V>
{
  Maps$FilteredEntryMap$KeySet(Maps.FilteredEntryMap paramFilteredEntryMap)
  {
    super(paramFilteredEntryMap);
  }
  
  public boolean remove(Object o)
  {
    if (this$0.containsKey(o))
    {
      this$0.unfiltered.remove(o);
      return true;
    }
    return false;
  }
  
  private boolean removeIf(Predicate<? super K> keyPredicate)
  {
    return Iterables.removeIf(this$0.unfiltered.entrySet(), Predicates.and(this$0.predicate, Maps.keyPredicateOnEntries(keyPredicate)));
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.FilteredEntryMap.KeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
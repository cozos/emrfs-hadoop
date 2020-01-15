package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Maps$FilteredKeyMap<K, V>
  extends Maps.AbstractFilteredMap<K, V>
{
  Predicate<? super K> keyPredicate;
  
  Maps$FilteredKeyMap(Map<K, V> unfiltered, Predicate<? super K> keyPredicate, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    super(unfiltered, entryPredicate);
    this.keyPredicate = keyPredicate;
  }
  
  protected Set<Map.Entry<K, V>> createEntrySet()
  {
    return Sets.filter(unfiltered.entrySet(), predicate);
  }
  
  Set<K> createKeySet()
  {
    return Sets.filter(unfiltered.keySet(), keyPredicate);
  }
  
  public boolean containsKey(Object key)
  {
    return (unfiltered.containsKey(key)) && (keyPredicate.apply(key));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.FilteredKeyMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
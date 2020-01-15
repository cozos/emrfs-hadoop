package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

abstract class Maps$AbstractFilteredMap<K, V>
  extends Maps.ImprovedAbstractMap<K, V>
{
  final Map<K, V> unfiltered;
  final Predicate<? super Map.Entry<K, V>> predicate;
  
  Maps$AbstractFilteredMap(Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> predicate)
  {
    this.unfiltered = unfiltered;
    this.predicate = predicate;
  }
  
  boolean apply(@Nullable Object key, @Nullable V value)
  {
    K k = (K)key;
    return predicate.apply(Maps.immutableEntry(k, value));
  }
  
  public V put(K key, V value)
  {
    Preconditions.checkArgument(apply(key, value));
    return (V)unfiltered.put(key, value);
  }
  
  public void putAll(Map<? extends K, ? extends V> map)
  {
    for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
      Preconditions.checkArgument(apply(entry.getKey(), entry.getValue()));
    }
    unfiltered.putAll(map);
  }
  
  public boolean containsKey(Object key)
  {
    return (unfiltered.containsKey(key)) && (apply(key, unfiltered.get(key)));
  }
  
  public V get(Object key)
  {
    V value = unfiltered.get(key);
    return (value != null) && (apply(key, value)) ? value : null;
  }
  
  public boolean isEmpty()
  {
    return entrySet().isEmpty();
  }
  
  public V remove(Object key)
  {
    return (V)(containsKey(key) ? unfiltered.remove(key) : null);
  }
  
  Collection<V> createValues()
  {
    return new Maps.FilteredMapValues(this, unfiltered, predicate);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.AbstractFilteredMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
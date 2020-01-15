package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

class MapConstraints$ConstrainedSortedSetMultimap<K, V>
  extends MapConstraints.ConstrainedSetMultimap<K, V>
  implements SortedSetMultimap<K, V>
{
  MapConstraints$ConstrainedSortedSetMultimap(SortedSetMultimap<K, V> delegate, MapConstraint<? super K, ? super V> constraint)
  {
    super(delegate, constraint);
  }
  
  public SortedSet<V> get(K key)
  {
    return (SortedSet)super.get(key);
  }
  
  public SortedSet<V> removeAll(Object key)
  {
    return (SortedSet)super.removeAll(key);
  }
  
  public SortedSet<V> replaceValues(K key, Iterable<? extends V> values)
  {
    return (SortedSet)super.replaceValues(key, values);
  }
  
  public Comparator<? super V> valueComparator()
  {
    return ((SortedSetMultimap)delegate()).valueComparator();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedSortedSetMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
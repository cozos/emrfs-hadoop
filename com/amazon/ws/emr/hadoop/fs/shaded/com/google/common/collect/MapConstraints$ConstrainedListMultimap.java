package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.List;

class MapConstraints$ConstrainedListMultimap<K, V>
  extends MapConstraints.ConstrainedMultimap<K, V>
  implements ListMultimap<K, V>
{
  MapConstraints$ConstrainedListMultimap(ListMultimap<K, V> delegate, MapConstraint<? super K, ? super V> constraint)
  {
    super(delegate, constraint);
  }
  
  public List<V> get(K key)
  {
    return (List)super.get(key);
  }
  
  public List<V> removeAll(Object key)
  {
    return (List)super.removeAll(key);
  }
  
  public List<V> replaceValues(K key, Iterable<? extends V> values)
  {
    return (List)super.replaceValues(key, values);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedListMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
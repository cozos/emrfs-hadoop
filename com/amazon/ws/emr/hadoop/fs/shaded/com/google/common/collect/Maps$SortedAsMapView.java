package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

class Maps$SortedAsMapView<K, V>
  extends Maps.AsMapView<K, V>
  implements SortedMap<K, V>
{
  Maps$SortedAsMapView(SortedSet<K> set, Function<? super K, V> function)
  {
    super(set, function);
  }
  
  SortedSet<K> backingSet()
  {
    return (SortedSet)super.backingSet();
  }
  
  public Comparator<? super K> comparator()
  {
    return backingSet().comparator();
  }
  
  public Set<K> keySet()
  {
    return Maps.access$300(backingSet());
  }
  
  public SortedMap<K, V> subMap(K fromKey, K toKey)
  {
    return Maps.asMap(backingSet().subSet(fromKey, toKey), function);
  }
  
  public SortedMap<K, V> headMap(K toKey)
  {
    return Maps.asMap(backingSet().headSet(toKey), function);
  }
  
  public SortedMap<K, V> tailMap(K fromKey)
  {
    return Maps.asMap(backingSet().tailSet(fromKey), function);
  }
  
  public K firstKey()
  {
    return (K)backingSet().first();
  }
  
  public K lastKey()
  {
    return (K)backingSet().last();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.SortedAsMapView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
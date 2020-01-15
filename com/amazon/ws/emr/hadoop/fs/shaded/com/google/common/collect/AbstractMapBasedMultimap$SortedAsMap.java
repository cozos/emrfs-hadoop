package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class AbstractMapBasedMultimap$SortedAsMap
  extends AbstractMapBasedMultimap<K, V>.AsMap
  implements SortedMap<K, Collection<V>>
{
  SortedSet<K> sortedKeySet;
  
  AbstractMapBasedMultimap$SortedAsMap(SortedMap<K, Collection<V>> arg1)
  {
    super(???, submap);
  }
  
  SortedMap<K, Collection<V>> sortedMap()
  {
    return (SortedMap)submap;
  }
  
  public Comparator<? super K> comparator()
  {
    return sortedMap().comparator();
  }
  
  public K firstKey()
  {
    return (K)sortedMap().firstKey();
  }
  
  public K lastKey()
  {
    return (K)sortedMap().lastKey();
  }
  
  public SortedMap<K, Collection<V>> headMap(K toKey)
  {
    return new SortedAsMap(this$0, sortedMap().headMap(toKey));
  }
  
  public SortedMap<K, Collection<V>> subMap(K fromKey, K toKey)
  {
    return new SortedAsMap(this$0, sortedMap().subMap(fromKey, toKey));
  }
  
  public SortedMap<K, Collection<V>> tailMap(K fromKey)
  {
    return new SortedAsMap(this$0, sortedMap().tailMap(fromKey));
  }
  
  public SortedSet<K> keySet()
  {
    SortedSet<K> result = sortedKeySet;
    return result == null ? (sortedKeySet = createKeySet()) : result;
  }
  
  SortedSet<K> createKeySet()
  {
    return new AbstractMapBasedMultimap.SortedKeySet(this$0, sortedMap());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
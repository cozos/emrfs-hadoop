package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class AbstractMapBasedMultimap$SortedKeySet
  extends AbstractMapBasedMultimap<K, V>.KeySet
  implements SortedSet<K>
{
  AbstractMapBasedMultimap$SortedKeySet(SortedMap<K, Collection<V>> arg1)
  {
    super(???, subMap);
  }
  
  SortedMap<K, Collection<V>> sortedMap()
  {
    return (SortedMap)super.map();
  }
  
  public Comparator<? super K> comparator()
  {
    return sortedMap().comparator();
  }
  
  public K first()
  {
    return (K)sortedMap().firstKey();
  }
  
  public SortedSet<K> headSet(K toElement)
  {
    return new SortedKeySet(this$0, sortedMap().headMap(toElement));
  }
  
  public K last()
  {
    return (K)sortedMap().lastKey();
  }
  
  public SortedSet<K> subSet(K fromElement, K toElement)
  {
    return new SortedKeySet(this$0, sortedMap().subMap(fromElement, toElement));
  }
  
  public SortedSet<K> tailSet(K fromElement)
  {
    return new SortedKeySet(this$0, sortedMap().tailMap(fromElement));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
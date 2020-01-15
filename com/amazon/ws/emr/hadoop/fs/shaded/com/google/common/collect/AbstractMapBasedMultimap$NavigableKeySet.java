package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;

@GwtIncompatible("NavigableSet")
class AbstractMapBasedMultimap$NavigableKeySet
  extends AbstractMapBasedMultimap<K, V>.SortedKeySet
  implements NavigableSet<K>
{
  AbstractMapBasedMultimap$NavigableKeySet(NavigableMap<K, Collection<V>> arg1)
  {
    super(???, subMap);
  }
  
  NavigableMap<K, Collection<V>> sortedMap()
  {
    return (NavigableMap)super.sortedMap();
  }
  
  public K lower(K k)
  {
    return (K)sortedMap().lowerKey(k);
  }
  
  public K floor(K k)
  {
    return (K)sortedMap().floorKey(k);
  }
  
  public K ceiling(K k)
  {
    return (K)sortedMap().ceilingKey(k);
  }
  
  public K higher(K k)
  {
    return (K)sortedMap().higherKey(k);
  }
  
  public K pollFirst()
  {
    return (K)Iterators.pollNext(iterator());
  }
  
  public K pollLast()
  {
    return (K)Iterators.pollNext(descendingIterator());
  }
  
  public NavigableSet<K> descendingSet()
  {
    return new NavigableKeySet(this$0, sortedMap().descendingMap());
  }
  
  public Iterator<K> descendingIterator()
  {
    return descendingSet().iterator();
  }
  
  public NavigableSet<K> headSet(K toElement)
  {
    return headSet(toElement, false);
  }
  
  public NavigableSet<K> headSet(K toElement, boolean inclusive)
  {
    return new NavigableKeySet(this$0, sortedMap().headMap(toElement, inclusive));
  }
  
  public NavigableSet<K> subSet(K fromElement, K toElement)
  {
    return subSet(fromElement, true, toElement, false);
  }
  
  public NavigableSet<K> subSet(K fromElement, boolean fromInclusive, K toElement, boolean toInclusive)
  {
    return new NavigableKeySet(this$0, sortedMap().subMap(fromElement, fromInclusive, toElement, toInclusive));
  }
  
  public NavigableSet<K> tailSet(K fromElement)
  {
    return tailSet(fromElement, true);
  }
  
  public NavigableSet<K> tailSet(K fromElement, boolean inclusive)
  {
    return new NavigableKeySet(this$0, sortedMap().tailMap(fromElement, inclusive));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.NavigableKeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
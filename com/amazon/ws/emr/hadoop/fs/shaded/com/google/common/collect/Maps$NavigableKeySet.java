package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtIncompatible("NavigableMap")
class Maps$NavigableKeySet<K, V>
  extends Maps.SortedKeySet<K, V>
  implements NavigableSet<K>
{
  Maps$NavigableKeySet(NavigableMap<K, V> map)
  {
    super(map);
  }
  
  NavigableMap<K, V> map()
  {
    return (NavigableMap)map;
  }
  
  public K lower(K e)
  {
    return (K)map().lowerKey(e);
  }
  
  public K floor(K e)
  {
    return (K)map().floorKey(e);
  }
  
  public K ceiling(K e)
  {
    return (K)map().ceilingKey(e);
  }
  
  public K higher(K e)
  {
    return (K)map().higherKey(e);
  }
  
  public K pollFirst()
  {
    return (K)Maps.keyOrNull(map().pollFirstEntry());
  }
  
  public K pollLast()
  {
    return (K)Maps.keyOrNull(map().pollLastEntry());
  }
  
  public NavigableSet<K> descendingSet()
  {
    return map().descendingKeySet();
  }
  
  public Iterator<K> descendingIterator()
  {
    return descendingSet().iterator();
  }
  
  public NavigableSet<K> subSet(K fromElement, boolean fromInclusive, K toElement, boolean toInclusive)
  {
    return map().subMap(fromElement, fromInclusive, toElement, toInclusive).navigableKeySet();
  }
  
  public NavigableSet<K> headSet(K toElement, boolean inclusive)
  {
    return map().headMap(toElement, inclusive).navigableKeySet();
  }
  
  public NavigableSet<K> tailSet(K fromElement, boolean inclusive)
  {
    return map().tailMap(fromElement, inclusive).navigableKeySet();
  }
  
  public SortedSet<K> subSet(K fromElement, K toElement)
  {
    return subSet(fromElement, true, toElement, false);
  }
  
  public SortedSet<K> headSet(K toElement)
  {
    return headSet(toElement, false);
  }
  
  public SortedSet<K> tailSet(K fromElement)
  {
    return tailSet(fromElement, true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.NavigableKeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
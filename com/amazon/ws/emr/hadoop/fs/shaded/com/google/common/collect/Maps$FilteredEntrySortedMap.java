package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.SortedSet;

class Maps$FilteredEntrySortedMap<K, V>
  extends Maps.FilteredEntryMap<K, V>
  implements SortedMap<K, V>
{
  Maps$FilteredEntrySortedMap(SortedMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    super(unfiltered, entryPredicate);
  }
  
  SortedMap<K, V> sortedMap()
  {
    return (SortedMap)unfiltered;
  }
  
  public SortedSet<K> keySet()
  {
    return (SortedSet)super.keySet();
  }
  
  SortedSet<K> createKeySet()
  {
    return new SortedKeySet();
  }
  
  class SortedKeySet
    extends Maps.FilteredEntryMap<K, V>.KeySet
    implements SortedSet<K>
  {
    SortedKeySet()
    {
      super();
    }
    
    public Comparator<? super K> comparator()
    {
      return sortedMap().comparator();
    }
    
    public SortedSet<K> subSet(K fromElement, K toElement)
    {
      return (SortedSet)subMap(fromElement, toElement).keySet();
    }
    
    public SortedSet<K> headSet(K toElement)
    {
      return (SortedSet)headMap(toElement).keySet();
    }
    
    public SortedSet<K> tailSet(K fromElement)
    {
      return (SortedSet)tailMap(fromElement).keySet();
    }
    
    public K first()
    {
      return (K)firstKey();
    }
    
    public K last()
    {
      return (K)lastKey();
    }
  }
  
  public Comparator<? super K> comparator()
  {
    return sortedMap().comparator();
  }
  
  public K firstKey()
  {
    return (K)keySet().iterator().next();
  }
  
  public K lastKey()
  {
    SortedMap<K, V> headMap = sortedMap();
    for (;;)
    {
      K key = headMap.lastKey();
      if (apply(key, unfiltered.get(key))) {
        return key;
      }
      headMap = sortedMap().headMap(key);
    }
  }
  
  public SortedMap<K, V> headMap(K toKey)
  {
    return new FilteredEntrySortedMap(sortedMap().headMap(toKey), predicate);
  }
  
  public SortedMap<K, V> subMap(K fromKey, K toKey)
  {
    return new FilteredEntrySortedMap(sortedMap().subMap(fromKey, toKey), predicate);
  }
  
  public SortedMap<K, V> tailMap(K fromKey)
  {
    return new FilteredEntrySortedMap(sortedMap().tailMap(fromKey), predicate);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.FilteredEntrySortedMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
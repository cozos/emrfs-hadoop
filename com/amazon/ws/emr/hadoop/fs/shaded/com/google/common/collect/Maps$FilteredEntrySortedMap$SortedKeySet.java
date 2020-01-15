package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class Maps$FilteredEntrySortedMap$SortedKeySet
  extends Maps.FilteredEntryMap<K, V>.KeySet
  implements SortedSet<K>
{
  Maps$FilteredEntrySortedMap$SortedKeySet(Maps.FilteredEntrySortedMap paramFilteredEntrySortedMap)
  {
    super(paramFilteredEntrySortedMap);
  }
  
  public Comparator<? super K> comparator()
  {
    return this$0.sortedMap().comparator();
  }
  
  public SortedSet<K> subSet(K fromElement, K toElement)
  {
    return (SortedSet)this$0.subMap(fromElement, toElement).keySet();
  }
  
  public SortedSet<K> headSet(K toElement)
  {
    return (SortedSet)this$0.headMap(toElement).keySet();
  }
  
  public SortedSet<K> tailSet(K fromElement)
  {
    return (SortedSet)this$0.tailMap(fromElement).keySet();
  }
  
  public K first()
  {
    return (K)this$0.firstKey();
  }
  
  public K last()
  {
    return (K)this$0.lastKey();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.FilteredEntrySortedMap.SortedKeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
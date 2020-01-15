package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.SortedMap;

class Maps$TransformedEntriesSortedMap<K, V1, V2>
  extends Maps.TransformedEntriesMap<K, V1, V2>
  implements SortedMap<K, V2>
{
  protected SortedMap<K, V1> fromMap()
  {
    return (SortedMap)fromMap;
  }
  
  Maps$TransformedEntriesSortedMap(SortedMap<K, V1> fromMap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    super(fromMap, transformer);
  }
  
  public Comparator<? super K> comparator()
  {
    return fromMap().comparator();
  }
  
  public K firstKey()
  {
    return (K)fromMap().firstKey();
  }
  
  public SortedMap<K, V2> headMap(K toKey)
  {
    return Maps.transformEntries(fromMap().headMap(toKey), transformer);
  }
  
  public K lastKey()
  {
    return (K)fromMap().lastKey();
  }
  
  public SortedMap<K, V2> subMap(K fromKey, K toKey)
  {
    return Maps.transformEntries(fromMap().subMap(fromKey, toKey), transformer);
  }
  
  public SortedMap<K, V2> tailMap(K fromKey)
  {
    return Maps.transformEntries(fromMap().tailMap(fromKey), transformer);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.TransformedEntriesSortedMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
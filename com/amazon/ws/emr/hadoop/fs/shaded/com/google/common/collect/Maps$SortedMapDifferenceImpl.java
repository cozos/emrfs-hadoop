package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.SortedMap;

class Maps$SortedMapDifferenceImpl<K, V>
  extends Maps.MapDifferenceImpl<K, V>
  implements SortedMapDifference<K, V>
{
  Maps$SortedMapDifferenceImpl(SortedMap<K, V> onlyOnLeft, SortedMap<K, V> onlyOnRight, SortedMap<K, V> onBoth, SortedMap<K, MapDifference.ValueDifference<V>> differences)
  {
    super(onlyOnLeft, onlyOnRight, onBoth, differences);
  }
  
  public SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering()
  {
    return (SortedMap)super.entriesDiffering();
  }
  
  public SortedMap<K, V> entriesInCommon()
  {
    return (SortedMap)super.entriesInCommon();
  }
  
  public SortedMap<K, V> entriesOnlyOnLeft()
  {
    return (SortedMap)super.entriesOnlyOnLeft();
  }
  
  public SortedMap<K, V> entriesOnlyOnRight()
  {
    return (SortedMap)super.entriesOnlyOnRight();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.SortedMapDifferenceImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
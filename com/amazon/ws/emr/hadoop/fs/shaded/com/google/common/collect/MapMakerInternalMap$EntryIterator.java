package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

final class MapMakerInternalMap$EntryIterator
  extends MapMakerInternalMap<K, V>.HashIterator<Map.Entry<K, V>>
{
  MapMakerInternalMap$EntryIterator(MapMakerInternalMap paramMapMakerInternalMap)
  {
    super(paramMapMakerInternalMap);
  }
  
  public Map.Entry<K, V> next()
  {
    return nextEntry();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.EntryIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
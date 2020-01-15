package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

final class MapMakerInternalMap$ValueIterator
  extends MapMakerInternalMap<K, V>.HashIterator<V>
{
  MapMakerInternalMap$ValueIterator(MapMakerInternalMap paramMapMakerInternalMap)
  {
    super(paramMapMakerInternalMap);
  }
  
  public V next()
  {
    return (V)nextEntry().getValue();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.ValueIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

final class MapMakerInternalMap$KeyIterator
  extends MapMakerInternalMap<K, V>.HashIterator<K>
{
  MapMakerInternalMap$KeyIterator(MapMakerInternalMap paramMapMakerInternalMap)
  {
    super(paramMapMakerInternalMap);
  }
  
  public K next()
  {
    return (K)nextEntry().getKey();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.KeyIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
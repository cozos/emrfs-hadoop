package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class MapMakerInternalMap$EvictionQueue$1
  extends MapMakerInternalMap.AbstractReferenceEntry<K, V>
{
  MapMakerInternalMap.ReferenceEntry<K, V> nextEvictable = this;
  
  MapMakerInternalMap$EvictionQueue$1(MapMakerInternalMap.EvictionQueue paramEvictionQueue) {}
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
  {
    return nextEvictable;
  }
  
  public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    nextEvictable = next;
  }
  
  MapMakerInternalMap.ReferenceEntry<K, V> previousEvictable = this;
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
  {
    return previousEvictable;
  }
  
  public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
  {
    previousEvictable = previous;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.EvictionQueue.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
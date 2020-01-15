package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class MapMakerInternalMap$ExpirationQueue$1
  extends MapMakerInternalMap.AbstractReferenceEntry<K, V>
{
  MapMakerInternalMap$ExpirationQueue$1(MapMakerInternalMap.ExpirationQueue paramExpirationQueue) {}
  
  public long getExpirationTime()
  {
    return Long.MAX_VALUE;
  }
  
  MapMakerInternalMap.ReferenceEntry<K, V> nextExpirable = this;
  
  public void setExpirationTime(long time) {}
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
  {
    return nextExpirable;
  }
  
  public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    nextExpirable = next;
  }
  
  MapMakerInternalMap.ReferenceEntry<K, V> previousExpirable = this;
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
  {
    return previousExpirable;
  }
  
  public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
  {
    previousExpirable = previous;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.ExpirationQueue.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class MapMakerInternalMap$ExpirationQueue$2
  extends AbstractSequentialIterator<MapMakerInternalMap.ReferenceEntry<K, V>>
{
  MapMakerInternalMap$ExpirationQueue$2(MapMakerInternalMap.ExpirationQueue paramExpirationQueue, MapMakerInternalMap.ReferenceEntry x0)
  {
    super(x0);
  }
  
  protected MapMakerInternalMap.ReferenceEntry<K, V> computeNext(MapMakerInternalMap.ReferenceEntry<K, V> previous)
  {
    MapMakerInternalMap.ReferenceEntry<K, V> next = previous.getNextExpirable();
    return next == this$0.head ? null : next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.ExpirationQueue.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractSet;
import java.util.Iterator;

final class MapMakerInternalMap$KeySet
  extends AbstractSet<K>
{
  MapMakerInternalMap$KeySet(MapMakerInternalMap paramMapMakerInternalMap) {}
  
  public Iterator<K> iterator()
  {
    return new MapMakerInternalMap.KeyIterator(this$0);
  }
  
  public int size()
  {
    return this$0.size();
  }
  
  public boolean isEmpty()
  {
    return this$0.isEmpty();
  }
  
  public boolean contains(Object o)
  {
    return this$0.containsKey(o);
  }
  
  public boolean remove(Object o)
  {
    return this$0.remove(o) != null;
  }
  
  public void clear()
  {
    this$0.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.KeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
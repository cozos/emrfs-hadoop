package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Iterator;

final class MapMakerInternalMap$Values
  extends AbstractCollection<V>
{
  MapMakerInternalMap$Values(MapMakerInternalMap paramMapMakerInternalMap) {}
  
  public Iterator<V> iterator()
  {
    return new MapMakerInternalMap.ValueIterator(this$0);
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
    return this$0.containsValue(o);
  }
  
  public void clear()
  {
    this$0.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.Values
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
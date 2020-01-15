package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class AbstractMapBasedMultimap$AsMap$AsMapEntries
  extends Maps.EntrySet<K, Collection<V>>
{
  AbstractMapBasedMultimap$AsMap$AsMapEntries(AbstractMapBasedMultimap.AsMap paramAsMap) {}
  
  Map<K, Collection<V>> map()
  {
    return this$1;
  }
  
  public Iterator<Map.Entry<K, Collection<V>>> iterator()
  {
    return new AbstractMapBasedMultimap.AsMap.AsMapIterator(this$1);
  }
  
  public boolean contains(Object o)
  {
    return Collections2.safeContains(this$1.submap.entrySet(), o);
  }
  
  public boolean remove(Object o)
  {
    if (!contains(o)) {
      return false;
    }
    Map.Entry<?, ?> entry = (Map.Entry)o;
    AbstractMapBasedMultimap.access$400(this$1.this$0, entry.getKey());
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.AsMap.AsMapEntries
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
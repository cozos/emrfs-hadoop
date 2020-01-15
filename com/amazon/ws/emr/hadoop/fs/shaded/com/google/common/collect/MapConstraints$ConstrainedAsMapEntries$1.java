package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedAsMapEntries$1
  extends ForwardingIterator<Map.Entry<K, Collection<V>>>
{
  MapConstraints$ConstrainedAsMapEntries$1(MapConstraints.ConstrainedAsMapEntries paramConstrainedAsMapEntries, Iterator paramIterator) {}
  
  public Map.Entry<K, Collection<V>> next()
  {
    return MapConstraints.access$700((Map.Entry)val$iterator.next(), MapConstraints.ConstrainedAsMapEntries.access$600(this$0));
  }
  
  protected Iterator<Map.Entry<K, Collection<V>>> delegate()
  {
    return val$iterator;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedAsMapEntries.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
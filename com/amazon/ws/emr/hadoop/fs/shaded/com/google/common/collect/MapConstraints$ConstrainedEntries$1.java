package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedEntries$1
  extends ForwardingIterator<Map.Entry<K, V>>
{
  MapConstraints$ConstrainedEntries$1(MapConstraints.ConstrainedEntries paramConstrainedEntries, Iterator paramIterator) {}
  
  public Map.Entry<K, V> next()
  {
    return MapConstraints.access$500((Map.Entry)val$iterator.next(), this$0.constraint);
  }
  
  protected Iterator<Map.Entry<K, V>> delegate()
  {
    return val$iterator;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedEntries.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
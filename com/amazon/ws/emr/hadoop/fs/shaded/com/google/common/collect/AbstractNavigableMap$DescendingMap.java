package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;

final class AbstractNavigableMap$DescendingMap
  extends Maps.DescendingMap<K, V>
{
  private AbstractNavigableMap$DescendingMap(AbstractNavigableMap paramAbstractNavigableMap) {}
  
  NavigableMap<K, V> forward()
  {
    return this$0;
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    return this$0.descendingEntryIterator();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractNavigableMap.DescendingMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
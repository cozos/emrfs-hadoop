package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ListIterator;
import java.util.Map.Entry;

class LinkedListMultimap$3$1
  extends TransformedListIterator<Map.Entry<K, V>, V>
{
  LinkedListMultimap$3$1(LinkedListMultimap.3 param3, ListIterator x0, LinkedListMultimap.NodeIterator paramNodeIterator)
  {
    super(x0);
  }
  
  V transform(Map.Entry<K, V> entry)
  {
    return (V)entry.getValue();
  }
  
  public void set(V value)
  {
    val$nodeItr.setValue(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedListMultimap.3.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
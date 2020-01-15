package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Map.Entry;

class LinkedListMultimap$3
  extends AbstractSequentialList<V>
{
  LinkedListMultimap$3(LinkedListMultimap paramLinkedListMultimap) {}
  
  public int size()
  {
    return LinkedListMultimap.access$900(this$0);
  }
  
  public ListIterator<V> listIterator(int index)
  {
    final LinkedListMultimap<K, V>.NodeIterator nodeItr = new LinkedListMultimap.NodeIterator(this$0, index);
    new TransformedListIterator(nodeItr)
    {
      V transform(Map.Entry<K, V> entry)
      {
        return (V)entry.getValue();
      }
      
      public void set(V value)
      {
        nodeItr.setValue(value);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedListMultimap.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
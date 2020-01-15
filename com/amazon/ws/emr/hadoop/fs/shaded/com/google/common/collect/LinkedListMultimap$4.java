package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Map.Entry;

class LinkedListMultimap$4
  extends AbstractSequentialList<Map.Entry<K, V>>
{
  LinkedListMultimap$4(LinkedListMultimap paramLinkedListMultimap) {}
  
  public int size()
  {
    return LinkedListMultimap.access$900(this$0);
  }
  
  public ListIterator<Map.Entry<K, V>> listIterator(int index)
  {
    return new LinkedListMultimap.NodeIterator(this$0, index);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedListMultimap.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
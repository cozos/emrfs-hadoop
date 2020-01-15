package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Map;

class LinkedListMultimap$1
  extends AbstractSequentialList<V>
{
  LinkedListMultimap$1(LinkedListMultimap paramLinkedListMultimap, Object paramObject) {}
  
  public int size()
  {
    LinkedListMultimap.KeyList<K, V> keyList = (LinkedListMultimap.KeyList)LinkedListMultimap.access$600(this$0).get(val$key);
    return keyList == null ? 0 : count;
  }
  
  public ListIterator<V> listIterator(int index)
  {
    return new LinkedListMultimap.ValueForKeyIterator(this$0, val$key, index);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedListMultimap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
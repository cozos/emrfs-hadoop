package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

class LinkedListMultimap$2
  extends Sets.ImprovedAbstractSet<K>
{
  LinkedListMultimap$2(LinkedListMultimap paramLinkedListMultimap) {}
  
  public int size()
  {
    return LinkedListMultimap.access$600(this$0).size();
  }
  
  public Iterator<K> iterator()
  {
    return new LinkedListMultimap.DistinctKeyIterator(this$0, null);
  }
  
  public boolean contains(Object key)
  {
    return this$0.containsKey(key);
  }
  
  public boolean remove(Object o)
  {
    return !this$0.removeAll(o).isEmpty();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedListMultimap.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class FilteredKeyMultimap$AddRejectingList<K, V>
  extends ForwardingList<V>
{
  final K key;
  
  FilteredKeyMultimap$AddRejectingList(K key)
  {
    this.key = key;
  }
  
  public boolean add(V v)
  {
    add(0, v);
    return true;
  }
  
  public boolean addAll(Collection<? extends V> collection)
  {
    addAll(0, collection);
    return true;
  }
  
  public void add(int index, V element)
  {
    Preconditions.checkPositionIndex(index, 0);
    String str = String.valueOf(String.valueOf(key));throw new IllegalArgumentException(32 + str.length() + "Key does not satisfy predicate: " + str);
  }
  
  public boolean addAll(int index, Collection<? extends V> elements)
  {
    Preconditions.checkNotNull(elements);
    Preconditions.checkPositionIndex(index, 0);
    String str = String.valueOf(String.valueOf(key));throw new IllegalArgumentException(32 + str.length() + "Key does not satisfy predicate: " + str);
  }
  
  protected List<V> delegate()
  {
    return Collections.emptyList();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredKeyMultimap.AddRejectingList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

class FilteredKeyMultimap$AddRejectingSet<K, V>
  extends ForwardingSet<V>
{
  final K key;
  
  FilteredKeyMultimap$AddRejectingSet(K key)
  {
    this.key = key;
  }
  
  public boolean add(V element)
  {
    String str = String.valueOf(String.valueOf(key));throw new IllegalArgumentException(32 + str.length() + "Key does not satisfy predicate: " + str);
  }
  
  public boolean addAll(Collection<? extends V> collection)
  {
    Preconditions.checkNotNull(collection);
    String str = String.valueOf(String.valueOf(key));throw new IllegalArgumentException(32 + str.length() + "Key does not satisfy predicate: " + str);
  }
  
  protected Set<V> delegate()
  {
    return Collections.emptySet();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredKeyMultimap.AddRejectingSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
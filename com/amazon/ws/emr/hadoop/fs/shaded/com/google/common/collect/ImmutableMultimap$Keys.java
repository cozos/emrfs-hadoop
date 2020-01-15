package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class ImmutableMultimap$Keys
  extends ImmutableMultiset<K>
{
  ImmutableMultimap$Keys(ImmutableMultimap paramImmutableMultimap) {}
  
  public boolean contains(@Nullable Object object)
  {
    return this$0.containsKey(object);
  }
  
  public int count(@Nullable Object element)
  {
    Collection<V> values = (Collection)this$0.map.get(element);
    return values == null ? 0 : values.size();
  }
  
  public Set<K> elementSet()
  {
    return this$0.keySet();
  }
  
  public int size()
  {
    return this$0.size();
  }
  
  Multiset.Entry<K> getEntry(int index)
  {
    Map.Entry<K, ? extends Collection<V>> entry = (Map.Entry)this$0.map.entrySet().asList().get(index);
    return Multisets.immutableEntry(entry.getKey(), ((Collection)entry.getValue()).size());
  }
  
  boolean isPartialView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMultimap.Keys
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;
import javax.annotation.Nullable;

final class ImmutableSetMultimap$EntrySet<K, V>
  extends ImmutableSet<Map.Entry<K, V>>
{
  private final transient ImmutableSetMultimap<K, V> multimap;
  
  ImmutableSetMultimap$EntrySet(ImmutableSetMultimap<K, V> multimap)
  {
    this.multimap = multimap;
  }
  
  public boolean contains(@Nullable Object object)
  {
    if ((object instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)object;
      return multimap.containsEntry(entry.getKey(), entry.getValue());
    }
    return false;
  }
  
  public int size()
  {
    return multimap.size();
  }
  
  public UnmodifiableIterator<Map.Entry<K, V>> iterator()
  {
    return multimap.entryIterator();
  }
  
  boolean isPartialView()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSetMultimap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
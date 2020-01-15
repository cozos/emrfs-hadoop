package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

final class ImmutableMultimap$Values<K, V>
  extends ImmutableCollection<V>
{
  private final transient ImmutableMultimap<K, V> multimap;
  private static final long serialVersionUID = 0L;
  
  ImmutableMultimap$Values(ImmutableMultimap<K, V> multimap)
  {
    this.multimap = multimap;
  }
  
  public boolean contains(@Nullable Object object)
  {
    return multimap.containsValue(object);
  }
  
  public UnmodifiableIterator<V> iterator()
  {
    return multimap.valueIterator();
  }
  
  @GwtIncompatible("not present in emulated superclass")
  int copyIntoArray(Object[] dst, int offset)
  {
    for (ImmutableCollection<V> valueCollection : multimap.map.values()) {
      offset = valueCollection.copyIntoArray(dst, offset);
    }
    return offset;
  }
  
  public int size()
  {
    return multimap.size();
  }
  
  boolean isPartialView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMultimap.Values
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
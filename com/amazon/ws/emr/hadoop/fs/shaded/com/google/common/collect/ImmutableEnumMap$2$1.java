package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class ImmutableEnumMap$2$1
  extends UnmodifiableIterator<Map.Entry<K, V>>
{
  private final Iterator<Map.Entry<K, V>> backingIterator = ImmutableEnumMap.access$000(this$1.this$0).entrySet().iterator();
  
  ImmutableEnumMap$2$1(ImmutableEnumMap.2 param2) {}
  
  public boolean hasNext()
  {
    return backingIterator.hasNext();
  }
  
  public Map.Entry<K, V> next()
  {
    Map.Entry<K, V> entry = (Map.Entry)backingIterator.next();
    return Maps.immutableEntry(entry.getKey(), entry.getValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableEnumMap.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
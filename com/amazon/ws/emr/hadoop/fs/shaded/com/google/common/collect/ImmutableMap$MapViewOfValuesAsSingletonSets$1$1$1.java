package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMap$MapViewOfValuesAsSingletonSets$1$1$1
  extends AbstractMapEntry<K, ImmutableSet<V>>
{
  ImmutableMap$MapViewOfValuesAsSingletonSets$1$1$1(ImmutableMap.MapViewOfValuesAsSingletonSets.1.1 param1, Map.Entry paramEntry) {}
  
  public K getKey()
  {
    return (K)val$backingEntry.getKey();
  }
  
  public ImmutableSet<V> getValue()
  {
    return ImmutableSet.of(val$backingEntry.getValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.1.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
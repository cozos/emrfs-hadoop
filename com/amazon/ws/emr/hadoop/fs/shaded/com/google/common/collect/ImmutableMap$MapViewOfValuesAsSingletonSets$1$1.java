package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class ImmutableMap$MapViewOfValuesAsSingletonSets$1$1
  extends UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>>
{
  ImmutableMap$MapViewOfValuesAsSingletonSets$1$1(ImmutableMap.MapViewOfValuesAsSingletonSets.1 param1, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$backingIterator.hasNext();
  }
  
  public Map.Entry<K, ImmutableSet<V>> next()
  {
    final Map.Entry<K, V> backingEntry = (Map.Entry)val$backingIterator.next();
    new AbstractMapEntry()
    {
      public K getKey()
      {
        return (K)backingEntry.getKey();
      }
      
      public ImmutableSet<V> getValue()
      {
        return ImmutableSet.of(backingEntry.getValue());
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
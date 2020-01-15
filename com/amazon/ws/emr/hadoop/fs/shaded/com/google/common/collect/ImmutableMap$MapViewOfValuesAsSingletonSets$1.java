package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class ImmutableMap$MapViewOfValuesAsSingletonSets$1
  extends ImmutableMapEntrySet<K, ImmutableSet<V>>
{
  ImmutableMap$MapViewOfValuesAsSingletonSets$1(ImmutableMap.MapViewOfValuesAsSingletonSets paramMapViewOfValuesAsSingletonSets) {}
  
  ImmutableMap<K, ImmutableSet<V>> map()
  {
    return this$0;
  }
  
  public UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> iterator()
  {
    final Iterator<Map.Entry<K, V>> backingIterator = ImmutableMap.MapViewOfValuesAsSingletonSets.access$000(this$0).entrySet().iterator();
    new UnmodifiableIterator()
    {
      public boolean hasNext()
      {
        return backingIterator.hasNext();
      }
      
      public Map.Entry<K, ImmutableSet<V>> next()
      {
        final Map.Entry<K, V> backingEntry = (Map.Entry)backingIterator.next();
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
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
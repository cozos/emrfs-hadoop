package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class WellBehavedMap$EntrySet$1
  extends TransformedIterator<K, Map.Entry<K, V>>
{
  WellBehavedMap$EntrySet$1(WellBehavedMap.EntrySet paramEntrySet, Iterator x0)
  {
    super(x0);
  }
  
  Map.Entry<K, V> transform(final K key)
  {
    new AbstractMapEntry()
    {
      public K getKey()
      {
        return (K)key;
      }
      
      public V getValue()
      {
        return (V)this$1.this$0.get(key);
      }
      
      public V setValue(V value)
      {
        return (V)this$1.this$0.put(key, value);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.WellBehavedMap.EntrySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
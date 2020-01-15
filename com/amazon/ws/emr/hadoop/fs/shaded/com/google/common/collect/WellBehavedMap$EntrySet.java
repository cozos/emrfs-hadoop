package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class WellBehavedMap$EntrySet
  extends Maps.EntrySet<K, V>
{
  private WellBehavedMap$EntrySet(WellBehavedMap paramWellBehavedMap) {}
  
  Map<K, V> map()
  {
    return this$0;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    new TransformedIterator(this$0.keySet().iterator())
    {
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
            return (V)this$0.get(key);
          }
          
          public V setValue(V value)
          {
            return (V)this$0.put(key, value);
          }
        };
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.WellBehavedMap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class ArrayTable$ArrayMap$1
  extends Maps.EntrySet<K, V>
{
  ArrayTable$ArrayMap$1(ArrayTable.ArrayMap paramArrayMap) {}
  
  Map<K, V> map()
  {
    return this$0;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    new AbstractIndexedListIterator(size())
    {
      protected Map.Entry<K, V> get(final int index)
      {
        new AbstractMapEntry()
        {
          public K getKey()
          {
            return (K)this$0.getKey(index);
          }
          
          public V getValue()
          {
            return (V)this$0.getValue(index);
          }
          
          public V setValue(V value)
          {
            return (V)this$0.setValue(index, value);
          }
        };
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ArrayTable.ArrayMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract class DenseImmutableTable$ImmutableArrayMap<K, V>
  extends ImmutableMap<K, V>
{
  private final int size;
  
  DenseImmutableTable$ImmutableArrayMap(int size)
  {
    this.size = size;
  }
  
  abstract ImmutableMap<K, Integer> keyToIndex();
  
  private boolean isFull()
  {
    return size == keyToIndex().size();
  }
  
  K getKey(int index)
  {
    return (K)keyToIndex().keySet().asList().get(index);
  }
  
  @Nullable
  abstract V getValue(int paramInt);
  
  ImmutableSet<K> createKeySet()
  {
    return isFull() ? keyToIndex().keySet() : super.createKeySet();
  }
  
  public int size()
  {
    return size;
  }
  
  public V get(@Nullable Object key)
  {
    Integer keyIndex = (Integer)keyToIndex().get(key);
    return keyIndex == null ? null : getValue(keyIndex.intValue());
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    new ImmutableMapEntrySet()
    {
      ImmutableMap<K, V> map()
      {
        return DenseImmutableTable.ImmutableArrayMap.this;
      }
      
      public UnmodifiableIterator<Map.Entry<K, V>> iterator()
      {
        new AbstractIterator()
        {
          private int index = -1;
          private final int maxIndex = keyToIndex().size();
          
          protected Map.Entry<K, V> computeNext()
          {
            for (index += 1; index < maxIndex; index += 1)
            {
              V value = getValue(index);
              if (value != null) {
                return Maps.immutableEntry(getKey(index), value);
              }
            }
            return (Map.Entry)endOfData();
          }
        };
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

abstract class ArrayTable$ArrayMap<K, V>
  extends Maps.ImprovedAbstractMap<K, V>
{
  private final ImmutableMap<K, Integer> keyIndex;
  
  private ArrayTable$ArrayMap(ImmutableMap<K, Integer> keyIndex)
  {
    this.keyIndex = keyIndex;
  }
  
  public Set<K> keySet()
  {
    return keyIndex.keySet();
  }
  
  K getKey(int index)
  {
    return (K)keyIndex.keySet().asList().get(index);
  }
  
  abstract String getKeyRole();
  
  @Nullable
  abstract V getValue(int paramInt);
  
  @Nullable
  abstract V setValue(int paramInt, V paramV);
  
  public int size()
  {
    return keyIndex.size();
  }
  
  public boolean isEmpty()
  {
    return keyIndex.isEmpty();
  }
  
  protected Set<Map.Entry<K, V>> createEntrySet()
  {
    new Maps.EntrySet()
    {
      Map<K, V> map()
      {
        return ArrayTable.ArrayMap.this;
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
                return (K)getKey(index);
              }
              
              public V getValue()
              {
                return (V)getValue(index);
              }
              
              public V setValue(V value)
              {
                return (V)setValue(index, value);
              }
            };
          }
        };
      }
    };
  }
  
  public boolean containsKey(@Nullable Object key)
  {
    return keyIndex.containsKey(key);
  }
  
  public V get(@Nullable Object key)
  {
    Integer index = (Integer)keyIndex.get(key);
    if (index == null) {
      return null;
    }
    return (V)getValue(index.intValue());
  }
  
  public V put(K key, V value)
  {
    Integer index = (Integer)keyIndex.get(key);
    if (index == null)
    {
      String str1 = String.valueOf(String.valueOf(getKeyRole()));String str2 = String.valueOf(String.valueOf(key));String str3 = String.valueOf(String.valueOf(keyIndex.keySet()));throw new IllegalArgumentException(9 + str1.length() + str2.length() + str3.length() + str1 + " " + str2 + " not in " + str3);
    }
    return (V)setValue(index.intValue(), value);
  }
  
  public V remove(Object key)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ArrayTable.ArrayMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
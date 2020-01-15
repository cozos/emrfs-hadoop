package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;
import java.util.Map.Entry;

final class $ImmutableMap$RegularImmutableMap<K, V>
  extends .ImmutableMap<K, V>
{
  private final transient Map.Entry<K, V>[] entries;
  private final transient Object[] table;
  private final transient int mask;
  private final transient int keySetHashCode;
  private transient .ImmutableSet<Map.Entry<K, V>> entrySet;
  private transient .ImmutableSet<K> keySet;
  private transient .ImmutableCollection<V> values;
  
  private $ImmutableMap$RegularImmutableMap(Map.Entry<?, ?>... entries)
  {
    Map.Entry<K, V>[] tmp = (Map.Entry[])entries;
    this.entries = tmp;
    
    int tableSize = .Hashing.chooseTableSize(entries.length);
    table = new Object[tableSize * 2];
    mask = (tableSize - 1);
    
    int keySetHashCodeMutable = 0;
    for (Map.Entry<K, V> entry : this.entries)
    {
      K key = entry.getKey();
      int keyHashCode = key.hashCode();
      for (int i = .Hashing.smear(keyHashCode);; i++)
      {
        int index = (i & mask) * 2;
        Object existing = table[index];
        if (existing == null)
        {
          V value = entry.getValue();
          table[index] = key;
          table[(index + 1)] = value;
          keySetHashCodeMutable += keyHashCode;
          break;
        }
        if (existing.equals(key)) {
          throw new IllegalArgumentException("duplicate key: " + key);
        }
      }
    }
    keySetHashCode = keySetHashCodeMutable;
  }
  
  public V get(Object key)
  {
    if (key == null) {
      return null;
    }
    for (int i = .Hashing.smear(key.hashCode());; i++)
    {
      int index = (i & mask) * 2;
      Object candidate = table[index];
      if (candidate == null) {
        return null;
      }
      if (candidate.equals(key))
      {
        V value = table[(index + 1)];
        return value;
      }
    }
  }
  
  public int size()
  {
    return entries.length;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean containsKey(Object key)
  {
    return get(key) != null;
  }
  
  public boolean containsValue(Object value)
  {
    if (value == null) {
      return false;
    }
    for (Map.Entry<K, V> entry : entries) {
      if (entry.getValue().equals(value)) {
        return true;
      }
    }
    return false;
  }
  
  public .ImmutableSet<Map.Entry<K, V>> entrySet()
  {
    .ImmutableSet<Map.Entry<K, V>> es = entrySet;
    return es == null ? (entrySet = new EntrySet(this)) : es;
  }
  
  private static class EntrySet<K, V>
    extends .ImmutableSet.ArrayImmutableSet<Map.Entry<K, V>>
  {
    final .ImmutableMap.RegularImmutableMap<K, V> map;
    
    EntrySet(.ImmutableMap.RegularImmutableMap<K, V> map)
    {
      super();
      this.map = map;
    }
    
    public boolean contains(Object target)
    {
      if ((target instanceof Map.Entry))
      {
        Map.Entry<?, ?> entry = (Map.Entry)target;
        V mappedValue = map.get(entry.getKey());
        return (mappedValue != null) && (mappedValue.equals(entry.getValue()));
      }
      return false;
    }
  }
  
  public .ImmutableSet<K> keySet()
  {
    .ImmutableSet<K> ks = keySet;
    return ks == null ? (keySet = new KeySet(this)) : ks;
  }
  
  private static class KeySet<K, V>
    extends .ImmutableSet.TransformedImmutableSet<Map.Entry<K, V>, K>
  {
    final .ImmutableMap.RegularImmutableMap<K, V> map;
    
    KeySet(.ImmutableMap.RegularImmutableMap<K, V> map)
    {
      super(keySetHashCode);
      this.map = map;
    }
    
    K transform(Map.Entry<K, V> element)
    {
      return (K)element.getKey();
    }
    
    public boolean contains(Object target)
    {
      return map.containsKey(target);
    }
  }
  
  public .ImmutableCollection<V> values()
  {
    .ImmutableCollection<V> v = values;
    return v == null ? (values = new Values(this)) : v;
  }
  
  private static class Values<V>
    extends .ImmutableCollection<V>
  {
    final .ImmutableMap.RegularImmutableMap<?, V> map;
    
    Values(.ImmutableMap.RegularImmutableMap<?, V> map)
    {
      this.map = map;
    }
    
    public int size()
    {
      return map.entries.length;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public .UnmodifiableIterator<V> iterator()
    {
      Iterator<V> iterator = new .AbstractIterator()
      {
        int index = 0;
        
        protected V computeNext()
        {
          return (V)(index < map.entries.length ? map.entries[(index++)].getValue() : endOfData());
        }
      };
      return .Iterators.unmodifiableIterator(iterator);
    }
    
    public boolean contains(Object target)
    {
      return map.containsValue(target);
    }
  }
  
  public String toString()
  {
    StringBuilder result = new StringBuilder(size() * 16).append('{').append(entries[0]);
    for (int e = 1; e < entries.length; e++) {
      result.append(", ").append(entries[e].toString());
    }
    return '}';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.RegularImmutableMap
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
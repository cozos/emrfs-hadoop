package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ImmutableMapParameter<K, V>
  implements Map<K, V>
{
  private static final String UNMODIFIABLE_MESSAGE = "This is an immutable map.";
  private static final String DUPLICATED_KEY_MESSAGE = "Duplicate keys are provided.";
  private final Map<K, V> map;
  
  private ImmutableMapParameter(Map<K, V> map)
  {
    this.map = map;
  }
  
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  public static <K, V> ImmutableMapParameter<K, V> of(K k0, V v0)
  {
    Map<K, V> map = Collections.singletonMap(k0, v0);
    return new ImmutableMapParameter(map);
  }
  
  public static <K, V> ImmutableMapParameter<K, V> of(K k0, V v0, K k1, V v1)
  {
    Map<K, V> map = new HashMap();
    putAndWarnDuplicateKeys(map, k0, v0);
    putAndWarnDuplicateKeys(map, k1, v1);
    return new ImmutableMapParameter(map);
  }
  
  public static <K, V> ImmutableMapParameter<K, V> of(K k0, V v0, K k1, V v1, K k2, V v2)
  {
    Map<K, V> map = new HashMap();
    putAndWarnDuplicateKeys(map, k0, v0);
    putAndWarnDuplicateKeys(map, k1, v1);
    putAndWarnDuplicateKeys(map, k2, v2);
    return new ImmutableMapParameter(map);
  }
  
  public static <K, V> ImmutableMapParameter<K, V> of(K k0, V v0, K k1, V v1, K k2, V v2, K k3, V v3)
  {
    Map<K, V> map = new HashMap();
    putAndWarnDuplicateKeys(map, k0, v0);
    putAndWarnDuplicateKeys(map, k1, v1);
    putAndWarnDuplicateKeys(map, k2, v2);
    putAndWarnDuplicateKeys(map, k3, v3);
    return new ImmutableMapParameter(map);
  }
  
  public static <K, V> ImmutableMapParameter<K, V> of(K k0, V v0, K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4)
  {
    Map<K, V> map = new HashMap();
    putAndWarnDuplicateKeys(map, k0, v0);
    putAndWarnDuplicateKeys(map, k1, v1);
    putAndWarnDuplicateKeys(map, k2, v2);
    putAndWarnDuplicateKeys(map, k3, v3);
    putAndWarnDuplicateKeys(map, k4, v4);
    return new ImmutableMapParameter(map);
  }
  
  public boolean containsKey(Object key)
  {
    return map.containsKey(key);
  }
  
  public boolean containsValue(Object value)
  {
    return map.containsValue(value);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return map.entrySet();
  }
  
  public V get(Object key)
  {
    return (V)map.get(key);
  }
  
  public boolean isEmpty()
  {
    return map.isEmpty();
  }
  
  public Set<K> keySet()
  {
    return map.keySet();
  }
  
  public int size()
  {
    return map.size();
  }
  
  public Collection<V> values()
  {
    return map.values();
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("This is an immutable map.");
  }
  
  public V put(K key, V value)
  {
    throw new UnsupportedOperationException("This is an immutable map.");
  }
  
  public void putAll(Map<? extends K, ? extends V> map)
  {
    throw new UnsupportedOperationException("This is an immutable map.");
  }
  
  public V remove(Object key)
  {
    throw new UnsupportedOperationException("This is an immutable map.");
  }
  
  private static <K, V> void putAndWarnDuplicateKeys(Map<K, V> map, K key, V value)
  {
    if (map.containsKey(key)) {
      throw new IllegalArgumentException("Duplicate keys are provided.");
    }
    map.put(key, value);
  }
  
  public boolean equals(Object o)
  {
    return map.equals(o);
  }
  
  public int hashCode()
  {
    return map.hashCode();
  }
  
  public String toString()
  {
    return map.toString();
  }
  
  public static class Builder<K, V>
  {
    private final Map<K, V> entries;
    
    public Builder()
    {
      entries = new HashMap();
    }
    
    public Builder<K, V> put(K key, V value)
    {
      ImmutableMapParameter.putAndWarnDuplicateKeys(entries, key, value);
      return this;
    }
    
    public ImmutableMapParameter<K, V> build()
    {
      HashMap<K, V> builtMap = new HashMap();
      builtMap.putAll(entries);
      return new ImmutableMapParameter(builtMap, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ImmutableMapParameter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
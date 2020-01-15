package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SdkInternalMap<K, V>
  implements Map<K, V>, Serializable
{
  private static final long serialVersionUID = 1L;
  private final Map<K, V> map;
  private final boolean autoConstruct;
  
  public SdkInternalMap()
  {
    map = new HashMap();
    autoConstruct = true;
  }
  
  public SdkInternalMap(Map<K, V> m)
  {
    map = m;
    autoConstruct = false;
  }
  
  public boolean isAutoConstruct()
  {
    return autoConstruct;
  }
  
  public int size()
  {
    return map.size();
  }
  
  public boolean isEmpty()
  {
    return map.isEmpty();
  }
  
  public boolean containsKey(Object key)
  {
    return map.containsKey(key);
  }
  
  public boolean containsValue(Object value)
  {
    return map.containsValue(value);
  }
  
  public V get(Object key)
  {
    return (V)map.get(key);
  }
  
  public V put(K key, V value)
  {
    return (V)map.put(key, value);
  }
  
  public V remove(Object key)
  {
    return (V)map.remove(key);
  }
  
  public void putAll(Map<? extends K, ? extends V> m)
  {
    map.putAll(m);
  }
  
  public void clear()
  {
    map.clear();
  }
  
  public Set<K> keySet()
  {
    return map.keySet();
  }
  
  public Collection<V> values()
  {
    return map.values();
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return map.entrySet();
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if (map == null) {
      return o == null;
    }
    if (!(o instanceof Map)) {
      return false;
    }
    Map<?, ?> that = (Map)o;
    
    return map.equals(that);
  }
  
  public int hashCode()
  {
    return map == null ? 0 : map.hashCode();
  }
  
  public String toString()
  {
    return map == null ? null : map.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
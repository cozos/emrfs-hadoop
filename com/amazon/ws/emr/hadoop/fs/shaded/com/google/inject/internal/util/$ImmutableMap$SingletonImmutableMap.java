package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class $ImmutableMap$SingletonImmutableMap<K, V>
  extends .ImmutableMap<K, V>
{
  private final transient K singleKey;
  private final transient V singleValue;
  private transient Map.Entry<K, V> entry;
  private transient .ImmutableSet<Map.Entry<K, V>> entrySet;
  private transient .ImmutableSet<K> keySet;
  private transient .ImmutableCollection<V> values;
  
  private $ImmutableMap$SingletonImmutableMap(K singleKey, V singleValue)
  {
    this.singleKey = singleKey;
    this.singleValue = singleValue;
  }
  
  private $ImmutableMap$SingletonImmutableMap(Map.Entry<K, V> entry)
  {
    this.entry = entry;
    singleKey = entry.getKey();
    singleValue = entry.getValue();
  }
  
  private Map.Entry<K, V> entry()
  {
    Map.Entry<K, V> e = entry;
    return e == null ? (entry = .Maps.immutableEntry(singleKey, singleValue)) : e;
  }
  
  public V get(Object key)
  {
    return (V)(singleKey.equals(key) ? singleValue : null);
  }
  
  public int size()
  {
    return 1;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean containsKey(Object key)
  {
    return singleKey.equals(key);
  }
  
  public boolean containsValue(Object value)
  {
    return singleValue.equals(value);
  }
  
  public .ImmutableSet<Map.Entry<K, V>> entrySet()
  {
    .ImmutableSet<Map.Entry<K, V>> es = entrySet;
    return es == null ? (entrySet = .ImmutableSet.of(entry())) : es;
  }
  
  public .ImmutableSet<K> keySet()
  {
    .ImmutableSet<K> ks = keySet;
    return ks == null ? (keySet = .ImmutableSet.of(singleKey)) : ks;
  }
  
  public .ImmutableCollection<V> values()
  {
    .ImmutableCollection<V> v = values;
    return v == null ? (values = new Values(singleValue)) : v;
  }
  
  private static class Values<V>
    extends .ImmutableCollection<V>
  {
    final V singleValue;
    
    Values(V singleValue)
    {
      this.singleValue = singleValue;
    }
    
    public boolean contains(Object object)
    {
      return singleValue.equals(object);
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public int size()
    {
      return 1;
    }
    
    public .UnmodifiableIterator<V> iterator()
    {
      return .Iterators.singletonIterator(singleValue);
    }
  }
  
  public boolean equals(@.Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof Map))
    {
      Map<?, ?> that = (Map)object;
      if (that.size() != 1) {
        return false;
      }
      Map.Entry<?, ?> entry = (Map.Entry)that.entrySet().iterator().next();
      return (singleKey.equals(entry.getKey())) && (singleValue.equals(entry.getValue()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return singleKey.hashCode() ^ singleValue.hashCode();
  }
  
  public String toString()
  {
    return '{' + singleKey.toString() + '=' + singleValue.toString() + '}';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.SingletonImmutableMap
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
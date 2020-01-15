package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public abstract class $ImmutableMap<K, V>
  implements ConcurrentMap<K, V>, Serializable
{
  private static final ImmutableMap<?, ?> EMPTY_IMMUTABLE_MAP = new EmptyImmutableMap(null);
  
  public static <K, V> ImmutableMap<K, V> of()
  {
    return EMPTY_IMMUTABLE_MAP;
  }
  
  public static <K, V> ImmutableMap<K, V> of(K k1, V v1)
  {
    return new SingletonImmutableMap(.Preconditions.checkNotNull(k1), .Preconditions.checkNotNull(v1), null);
  }
  
  public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(k1, v1), entryOf(k2, v2) }, null);
  }
  
  public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(k1, v1), entryOf(k2, v2), entryOf(k3, v3) }, null);
  }
  
  public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(k1, v1), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4) }, null);
  }
  
  public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(k1, v1), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4), entryOf(k5, v5) }, null);
  }
  
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  private static <K, V> Map.Entry<K, V> entryOf(K key, V value)
  {
    return .Maps.immutableEntry(.Preconditions.checkNotNull(key), .Preconditions.checkNotNull(value));
  }
  
  public static class Builder<K, V>
  {
    final List<Map.Entry<K, V>> entries = .Lists.newArrayList();
    
    public Builder<K, V> put(K key, V value)
    {
      entries.add(.ImmutableMap.entryOf(key, value));
      return this;
    }
    
    public Builder<K, V> putAll(Map<? extends K, ? extends V> map)
    {
      for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
        put(entry.getKey(), entry.getValue());
      }
      return this;
    }
    
    public .ImmutableMap<K, V> build()
    {
      return fromEntryList(entries);
    }
    
    private static <K, V> .ImmutableMap<K, V> fromEntryList(List<Map.Entry<K, V>> entries)
    {
      int size = entries.size();
      switch (size)
      {
      case 0: 
        return .ImmutableMap.of();
      case 1: 
        return new .ImmutableMap.SingletonImmutableMap((Map.Entry).Iterables.getOnlyElement(entries), null);
      }
      Map.Entry<?, ?>[] entryArray = (Map.Entry[])entries.toArray(new Map.Entry[entries.size()]);
      
      return new .ImmutableMap.RegularImmutableMap(entryArray, null);
    }
  }
  
  public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map)
  {
    if ((map instanceof ImmutableMap))
    {
      ImmutableMap<K, V> kvMap = (ImmutableMap)map;
      return kvMap;
    }
    int size = map.size();
    switch (size)
    {
    case 0: 
      return of();
    case 1: 
      Map.Entry<? extends K, ? extends V> loneEntry = (Map.Entry).Iterables.getOnlyElement(map.entrySet());
      
      return of(loneEntry.getKey(), loneEntry.getValue());
    }
    Map.Entry<?, ?>[] array = new Map.Entry[size];
    int i = 0;
    for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
      array[(i++)] = entryOf(entry.getKey(), entry.getValue());
    }
    return new RegularImmutableMap(array, null);
  }
  
  public final V put(K k, V v)
  {
    throw new UnsupportedOperationException();
  }
  
  public final V remove(Object o)
  {
    throw new UnsupportedOperationException();
  }
  
  public final V putIfAbsent(K key, V value)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean remove(Object key, Object value)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean replace(K key, V oldValue, V newValue)
  {
    throw new UnsupportedOperationException();
  }
  
  public final V replace(K key, V value)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void putAll(Map<? extends K, ? extends V> map)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean containsKey(@.Nullable Object paramObject);
  
  public abstract boolean containsValue(@.Nullable Object paramObject);
  
  public abstract V get(@.Nullable Object paramObject);
  
  public abstract .ImmutableSet<Map.Entry<K, V>> entrySet();
  
  public abstract .ImmutableSet<K> keySet();
  
  public abstract .ImmutableCollection<V> values();
  
  public boolean equals(@.Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof Map))
    {
      Map<?, ?> that = (Map)object;
      return entrySet().equals(that.entrySet());
    }
    return false;
  }
  
  public int hashCode()
  {
    return entrySet().hashCode();
  }
  
  public String toString()
  {
    StringBuilder result = new StringBuilder(size() * 16).append('{');
    Iterator<Map.Entry<K, V>> entries = entrySet().iterator();
    result.append(entries.next());
    while (entries.hasNext()) {
      result.append(", ").append(entries.next());
    }
    return '}';
  }
  
  private static final class EmptyImmutableMap
    extends .ImmutableMap<Object, Object>
  {
    public Object get(Object key)
    {
      return null;
    }
    
    public int size()
    {
      return 0;
    }
    
    public boolean isEmpty()
    {
      return true;
    }
    
    public boolean containsKey(Object key)
    {
      return false;
    }
    
    public boolean containsValue(Object value)
    {
      return false;
    }
    
    public .ImmutableSet<Map.Entry<Object, Object>> entrySet()
    {
      return .ImmutableSet.of();
    }
    
    public .ImmutableSet<Object> keySet()
    {
      return .ImmutableSet.of();
    }
    
    public .ImmutableCollection<Object> values()
    {
      return .ImmutableCollection.EMPTY_IMMUTABLE_COLLECTION;
    }
    
    public boolean equals(@.Nullable Object object)
    {
      if ((object instanceof Map))
      {
        Map<?, ?> that = (Map)object;
        return that.isEmpty();
      }
      return false;
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    public String toString()
    {
      return "{}";
    }
  }
  
  private static final class SingletonImmutableMap<K, V>
    extends .ImmutableMap<K, V>
  {
    private final transient K singleKey;
    private final transient V singleValue;
    private transient Map.Entry<K, V> entry;
    private transient .ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient .ImmutableSet<K> keySet;
    private transient .ImmutableCollection<V> values;
    
    private SingletonImmutableMap(K singleKey, V singleValue)
    {
      this.singleKey = singleKey;
      this.singleValue = singleValue;
    }
    
    private SingletonImmutableMap(Map.Entry<K, V> entry)
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
  
  private static final class RegularImmutableMap<K, V>
    extends .ImmutableMap<K, V>
  {
    private final transient Map.Entry<K, V>[] entries;
    private final transient Object[] table;
    private final transient int mask;
    private final transient int keySetHashCode;
    private transient .ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient .ImmutableSet<K> keySet;
    private transient .ImmutableCollection<V> values;
    
    private RegularImmutableMap(Map.Entry<?, ?>... entries)
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
  
  private static class SerializedForm
    implements Serializable
  {
    final Object[] keys;
    final Object[] values;
    private static final long serialVersionUID = 0L;
    
    SerializedForm(.ImmutableMap<?, ?> map)
    {
      keys = new Object[map.size()];
      values = new Object[map.size()];
      int i = 0;
      for (Map.Entry<?, ?> entry : map.entrySet())
      {
        keys[i] = entry.getKey();
        values[i] = entry.getValue();
        i++;
      }
    }
    
    Object readResolve()
    {
      .ImmutableMap.Builder<Object, Object> builder = new .ImmutableMap.Builder();
      for (int i = 0; i < keys.length; i++) {
        builder.put(keys[i], values[i]);
      }
      return builder.build();
    }
  }
  
  Object writeReplace()
  {
    return new SerializedForm(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
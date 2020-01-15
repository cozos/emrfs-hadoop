package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public abstract class ImmutableMap<K, V>
  implements Map<K, V>, Serializable
{
  public static <K, V> ImmutableMap<K, V> of()
  {
    return ImmutableBiMap.of();
  }
  
  public static <K, V> ImmutableMap<K, V> of(K k1, V v1)
  {
    return ImmutableBiMap.of(k1, v1);
  }
  
  public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2)
  {
    return new RegularImmutableMap(new ImmutableMapEntry.TerminalEntry[] { entryOf(k1, v1), entryOf(k2, v2) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3)
  {
    return new RegularImmutableMap(new ImmutableMapEntry.TerminalEntry[] { entryOf(k1, v1), entryOf(k2, v2), entryOf(k3, v3) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4)
  {
    return new RegularImmutableMap(new ImmutableMapEntry.TerminalEntry[] { entryOf(k1, v1), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5)
  {
    return new RegularImmutableMap(new ImmutableMapEntry.TerminalEntry[] { entryOf(k1, v1), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4), entryOf(k5, v5) });
  }
  
  static <K, V> ImmutableMapEntry.TerminalEntry<K, V> entryOf(K key, V value)
  {
    CollectPreconditions.checkEntryNotNull(key, value);
    return new ImmutableMapEntry.TerminalEntry(key, value);
  }
  
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  static void checkNoConflict(boolean safe, String conflictDescription, Map.Entry<?, ?> entry1, Map.Entry<?, ?> entry2)
  {
    if (!safe)
    {
      String str1 = String.valueOf(String.valueOf(conflictDescription));String str2 = String.valueOf(String.valueOf(entry1));String str3 = String.valueOf(String.valueOf(entry2));throw new IllegalArgumentException(34 + str1.length() + str2.length() + str3.length() + "Multiple entries with same " + str1 + ": " + str2 + " and " + str3);
    }
  }
  
  public static class Builder<K, V>
  {
    ImmutableMapEntry.TerminalEntry<K, V>[] entries;
    int size;
    
    public Builder()
    {
      this(4);
    }
    
    Builder(int initialCapacity)
    {
      entries = new ImmutableMapEntry.TerminalEntry[initialCapacity];
      size = 0;
    }
    
    private void ensureCapacity(int minCapacity)
    {
      if (minCapacity > entries.length) {
        entries = ((ImmutableMapEntry.TerminalEntry[])ObjectArrays.arraysCopyOf(entries, ImmutableCollection.Builder.expandedCapacity(entries.length, minCapacity)));
      }
    }
    
    public Builder<K, V> put(K key, V value)
    {
      ensureCapacity(size + 1);
      ImmutableMapEntry.TerminalEntry<K, V> entry = ImmutableMap.entryOf(key, value);
      
      entries[(size++)] = entry;
      return this;
    }
    
    public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry)
    {
      return put(entry.getKey(), entry.getValue());
    }
    
    public Builder<K, V> putAll(Map<? extends K, ? extends V> map)
    {
      ensureCapacity(size + map.size());
      for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
        put(entry);
      }
      return this;
    }
    
    public ImmutableMap<K, V> build()
    {
      switch (size)
      {
      case 0: 
        return ImmutableMap.of();
      case 1: 
        return ImmutableMap.of(entries[0].getKey(), entries[0].getValue());
      }
      return new RegularImmutableMap(size, entries);
    }
  }
  
  public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map)
  {
    if (((map instanceof ImmutableMap)) && (!(map instanceof ImmutableSortedMap)))
    {
      ImmutableMap<K, V> kvMap = (ImmutableMap)map;
      if (!kvMap.isPartialView()) {
        return kvMap;
      }
    }
    else if ((map instanceof EnumMap))
    {
      return copyOfEnumMapUnsafe(map);
    }
    Map.Entry<?, ?>[] entries = (Map.Entry[])map.entrySet().toArray(EMPTY_ENTRY_ARRAY);
    switch (entries.length)
    {
    case 0: 
      return of();
    case 1: 
      Map.Entry<K, V> onlyEntry = entries[0];
      return of(onlyEntry.getKey(), onlyEntry.getValue());
    }
    return new RegularImmutableMap(entries);
  }
  
  private static <K, V> ImmutableMap<K, V> copyOfEnumMapUnsafe(Map<? extends K, ? extends V> map)
  {
    return copyOfEnumMap((EnumMap)map);
  }
  
  private static <K extends Enum<K>, V> ImmutableMap<K, V> copyOfEnumMap(Map<K, ? extends V> original)
  {
    EnumMap<K, V> copy = new EnumMap(original);
    for (Map.Entry<?, ?> entry : copy.entrySet()) {
      CollectPreconditions.checkEntryNotNull(entry.getKey(), entry.getValue());
    }
    return ImmutableEnumMap.asImmutable(copy);
  }
  
  private static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
  private transient ImmutableSet<Map.Entry<K, V>> entrySet;
  private transient ImmutableSet<K> keySet;
  private transient ImmutableCollection<V> values;
  private transient ImmutableSetMultimap<K, V> multimapView;
  
  @Deprecated
  public final V put(K k, V v)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final V remove(Object o)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(Map<? extends K, ? extends V> map)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public boolean containsKey(@Nullable Object key)
  {
    return get(key) != null;
  }
  
  public boolean containsValue(@Nullable Object value)
  {
    return values().contains(value);
  }
  
  public abstract V get(@Nullable Object paramObject);
  
  public ImmutableSet<Map.Entry<K, V>> entrySet()
  {
    ImmutableSet<Map.Entry<K, V>> result = entrySet;
    return result == null ? (entrySet = createEntrySet()) : result;
  }
  
  abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();
  
  public ImmutableSet<K> keySet()
  {
    ImmutableSet<K> result = keySet;
    return result == null ? (keySet = createKeySet()) : result;
  }
  
  ImmutableSet<K> createKeySet()
  {
    return new ImmutableMapKeySet(this);
  }
  
  public ImmutableCollection<V> values()
  {
    ImmutableCollection<V> result = values;
    return result == null ? (values = new ImmutableMapValues(this)) : result;
  }
  
  @Beta
  public ImmutableSetMultimap<K, V> asMultimap()
  {
    ImmutableSetMultimap<K, V> result = multimapView;
    return result == null ? (multimapView = createMultimapView()) : result;
  }
  
  private ImmutableSetMultimap<K, V> createMultimapView()
  {
    ImmutableMap<K, ImmutableSet<V>> map = viewMapValuesAsSingletonSets();
    return new ImmutableSetMultimap(map, map.size(), null);
  }
  
  private ImmutableMap<K, ImmutableSet<V>> viewMapValuesAsSingletonSets()
  {
    return new MapViewOfValuesAsSingletonSets(this);
  }
  
  private static final class MapViewOfValuesAsSingletonSets<K, V>
    extends ImmutableMap<K, ImmutableSet<V>>
  {
    private final ImmutableMap<K, V> delegate;
    
    MapViewOfValuesAsSingletonSets(ImmutableMap<K, V> delegate)
    {
      this.delegate = ((ImmutableMap)Preconditions.checkNotNull(delegate));
    }
    
    public int size()
    {
      return delegate.size();
    }
    
    public boolean containsKey(@Nullable Object key)
    {
      return delegate.containsKey(key);
    }
    
    public ImmutableSet<V> get(@Nullable Object key)
    {
      V outerValue = delegate.get(key);
      return outerValue == null ? null : ImmutableSet.of(outerValue);
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    ImmutableSet<Map.Entry<K, ImmutableSet<V>>> createEntrySet()
    {
      new ImmutableMapEntrySet()
      {
        ImmutableMap<K, ImmutableSet<V>> map()
        {
          return ImmutableMap.MapViewOfValuesAsSingletonSets.this;
        }
        
        public UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> iterator()
        {
          final Iterator<Map.Entry<K, V>> backingIterator = entrySet().iterator();
          new UnmodifiableIterator()
          {
            public boolean hasNext()
            {
              return backingIterator.hasNext();
            }
            
            public Map.Entry<K, ImmutableSet<V>> next()
            {
              final Map.Entry<K, V> backingEntry = (Map.Entry)backingIterator.next();
              new AbstractMapEntry()
              {
                public K getKey()
                {
                  return (K)backingEntry.getKey();
                }
                
                public ImmutableSet<V> getValue()
                {
                  return ImmutableSet.of(backingEntry.getValue());
                }
              };
            }
          };
        }
      };
    }
  }
  
  public boolean equals(@Nullable Object object)
  {
    return Maps.equalsImpl(this, object);
  }
  
  abstract boolean isPartialView();
  
  public int hashCode()
  {
    return entrySet().hashCode();
  }
  
  public String toString()
  {
    return Maps.toStringImpl(this);
  }
  
  static class SerializedForm
    implements Serializable
  {
    private final Object[] keys;
    private final Object[] values;
    private static final long serialVersionUID = 0L;
    
    SerializedForm(ImmutableMap<?, ?> map)
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
      ImmutableMap.Builder<Object, Object> builder = new ImmutableMap.Builder();
      return createMap(builder);
    }
    
    Object createMap(ImmutableMap.Builder<Object, Object> builder)
    {
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
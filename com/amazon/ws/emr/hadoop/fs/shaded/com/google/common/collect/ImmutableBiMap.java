package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible(serializable=true, emulated=true)
public abstract class ImmutableBiMap<K, V>
  extends ImmutableMap<K, V>
  implements BiMap<K, V>
{
  public static <K, V> ImmutableBiMap<K, V> of()
  {
    return EmptyImmutableBiMap.INSTANCE;
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K k1, V v1)
  {
    return new SingletonImmutableBiMap(k1, v1);
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K k1, V v1, K k2, V v2)
  {
    return new RegularImmutableBiMap(new ImmutableMapEntry.TerminalEntry[] { entryOf(k1, v1), entryOf(k2, v2) });
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3)
  {
    return new RegularImmutableBiMap(new ImmutableMapEntry.TerminalEntry[] { entryOf(k1, v1), entryOf(k2, v2), entryOf(k3, v3) });
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4)
  {
    return new RegularImmutableBiMap(new ImmutableMapEntry.TerminalEntry[] { entryOf(k1, v1), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4) });
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5)
  {
    return new RegularImmutableBiMap(new ImmutableMapEntry.TerminalEntry[] { entryOf(k1, v1), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4), entryOf(k5, v5) });
  }
  
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  public static final class Builder<K, V>
    extends ImmutableMap.Builder<K, V>
  {
    public Builder<K, V> put(K key, V value)
    {
      super.put(key, value);
      return this;
    }
    
    public Builder<K, V> putAll(Map<? extends K, ? extends V> map)
    {
      super.putAll(map);
      return this;
    }
    
    public ImmutableBiMap<K, V> build()
    {
      switch (size)
      {
      case 0: 
        return ImmutableBiMap.of();
      case 1: 
        return ImmutableBiMap.of(entries[0].getKey(), entries[0].getValue());
      }
      return new RegularImmutableBiMap(size, entries);
    }
  }
  
  public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map)
  {
    if ((map instanceof ImmutableBiMap))
    {
      ImmutableBiMap<K, V> bimap = (ImmutableBiMap)map;
      if (!bimap.isPartialView()) {
        return bimap;
      }
    }
    Map.Entry<?, ?>[] entries = (Map.Entry[])map.entrySet().toArray(EMPTY_ENTRY_ARRAY);
    switch (entries.length)
    {
    case 0: 
      return of();
    case 1: 
      Map.Entry<K, V> entry = entries[0];
      return of(entry.getKey(), entry.getValue());
    }
    return new RegularImmutableBiMap(entries);
  }
  
  private static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
  
  public abstract ImmutableBiMap<V, K> inverse();
  
  public ImmutableSet<V> values()
  {
    return inverse().keySet();
  }
  
  @Deprecated
  public V forcePut(K key, V value)
  {
    throw new UnsupportedOperationException();
  }
  
  private static class SerializedForm
    extends ImmutableMap.SerializedForm
  {
    private static final long serialVersionUID = 0L;
    
    SerializedForm(ImmutableBiMap<?, ?> bimap)
    {
      super();
    }
    
    Object readResolve()
    {
      ImmutableBiMap.Builder<Object, Object> builder = new ImmutableBiMap.Builder();
      return createMap(builder);
    }
  }
  
  Object writeReplace()
  {
    return new SerializedForm(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableBiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
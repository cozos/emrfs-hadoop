package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map;

public final class ImmutableBiMap$Builder<K, V>
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableBiMap.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
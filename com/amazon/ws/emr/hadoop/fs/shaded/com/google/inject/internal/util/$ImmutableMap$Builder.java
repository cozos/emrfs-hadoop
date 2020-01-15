package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class $ImmutableMap$Builder<K, V>
{
  final List<Map.Entry<K, V>> entries = .Lists.newArrayList();
  
  public Builder<K, V> put(K key, V value)
  {
    entries.add(.ImmutableMap.access$300(key, value));
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
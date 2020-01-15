package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map;
import java.util.Map.Entry;

public class ImmutableMap$Builder<K, V>
{
  ImmutableMapEntry.TerminalEntry<K, V>[] entries;
  int size;
  
  public ImmutableMap$Builder()
  {
    this(4);
  }
  
  ImmutableMap$Builder(int initialCapacity)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
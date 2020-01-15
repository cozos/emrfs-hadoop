package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

final class RegularImmutableMap$NonTerminalMapEntry<K, V>
  extends ImmutableMapEntry<K, V>
{
  private final ImmutableMapEntry<K, V> nextInKeyBucket;
  
  RegularImmutableMap$NonTerminalMapEntry(K key, V value, ImmutableMapEntry<K, V> nextInKeyBucket)
  {
    super(key, value);
    this.nextInKeyBucket = nextInKeyBucket;
  }
  
  RegularImmutableMap$NonTerminalMapEntry(ImmutableMapEntry<K, V> contents, ImmutableMapEntry<K, V> nextInKeyBucket)
  {
    super(contents);
    this.nextInKeyBucket = nextInKeyBucket;
  }
  
  ImmutableMapEntry<K, V> getNextInKeyBucket()
  {
    return nextInKeyBucket;
  }
  
  @Nullable
  ImmutableMapEntry<K, V> getNextInValueBucket()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableMap.NonTerminalMapEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
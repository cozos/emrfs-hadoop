package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

final class RegularImmutableBiMap$NonTerminalBiMapEntry<K, V>
  extends ImmutableMapEntry<K, V>
{
  @Nullable
  private final ImmutableMapEntry<K, V> nextInKeyBucket;
  @Nullable
  private final ImmutableMapEntry<K, V> nextInValueBucket;
  
  RegularImmutableBiMap$NonTerminalBiMapEntry(K key, V value, @Nullable ImmutableMapEntry<K, V> nextInKeyBucket, @Nullable ImmutableMapEntry<K, V> nextInValueBucket)
  {
    super(key, value);
    this.nextInKeyBucket = nextInKeyBucket;
    this.nextInValueBucket = nextInValueBucket;
  }
  
  RegularImmutableBiMap$NonTerminalBiMapEntry(ImmutableMapEntry<K, V> contents, @Nullable ImmutableMapEntry<K, V> nextInKeyBucket, @Nullable ImmutableMapEntry<K, V> nextInValueBucket)
  {
    super(contents);
    this.nextInKeyBucket = nextInKeyBucket;
    this.nextInValueBucket = nextInValueBucket;
  }
  
  @Nullable
  ImmutableMapEntry<K, V> getNextInKeyBucket()
  {
    return nextInKeyBucket;
  }
  
  @Nullable
  ImmutableMapEntry<K, V> getNextInValueBucket()
  {
    return nextInValueBucket;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableBiMap.NonTerminalBiMapEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

final class HashBiMap$BiEntry<K, V>
  extends ImmutableEntry<K, V>
{
  final int keyHash;
  final int valueHash;
  @Nullable
  BiEntry<K, V> nextInKToVBucket;
  @Nullable
  BiEntry<K, V> nextInVToKBucket;
  
  HashBiMap$BiEntry(K key, int keyHash, V value, int valueHash)
  {
    super(key, value);
    this.keyHash = keyHash;
    this.valueHash = valueHash;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.HashBiMap.BiEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
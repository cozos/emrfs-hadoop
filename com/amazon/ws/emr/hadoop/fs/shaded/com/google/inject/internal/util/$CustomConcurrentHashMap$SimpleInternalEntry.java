package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $CustomConcurrentHashMap$SimpleInternalEntry<K, V>
{
  final K key;
  final int hash;
  final SimpleInternalEntry<K, V> next;
  volatile V value;
  
  $CustomConcurrentHashMap$SimpleInternalEntry(K key, int hash, @.Nullable V value, SimpleInternalEntry<K, V> next)
  {
    this.key = key;
    this.hash = hash;
    this.value = value;
    this.next = next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.SimpleInternalEntry
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
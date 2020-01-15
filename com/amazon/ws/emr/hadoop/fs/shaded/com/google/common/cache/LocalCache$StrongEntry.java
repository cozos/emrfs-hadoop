package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import javax.annotation.Nullable;

class LocalCache$StrongEntry<K, V>
  extends LocalCache.AbstractReferenceEntry<K, V>
{
  final K key;
  final int hash;
  final LocalCache.ReferenceEntry<K, V> next;
  
  LocalCache$StrongEntry(K key, int hash, @Nullable LocalCache.ReferenceEntry<K, V> next)
  {
    this.key = key;
    this.hash = hash;
    this.next = next;
  }
  
  public K getKey()
  {
    return (K)key;
  }
  
  volatile LocalCache.ValueReference<K, V> valueReference = LocalCache.unset();
  
  public LocalCache.ValueReference<K, V> getValueReference()
  {
    return valueReference;
  }
  
  public void setValueReference(LocalCache.ValueReference<K, V> valueReference)
  {
    this.valueReference = valueReference;
  }
  
  public int getHash()
  {
    return hash;
  }
  
  public LocalCache.ReferenceEntry<K, V> getNext()
  {
    return next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.StrongEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
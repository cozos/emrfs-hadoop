package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

final class $CustomConcurrentHashMap$Impl$WriteThroughEntry
  extends .AbstractMapEntry<K, V>
{
  final K key;
  V value;
  
  $CustomConcurrentHashMap$Impl$WriteThroughEntry(K arg1, V key)
  {
    this.key = key;
    this.value = value;
  }
  
  public K getKey()
  {
    return (K)key;
  }
  
  public V getValue()
  {
    return (V)value;
  }
  
  public V setValue(V value)
  {
    if (value == null) {
      throw new NullPointerException();
    }
    V oldValue = this$0.put(getKey(), value);
    this.value = value;
    return oldValue;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Impl.WriteThroughEntry
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
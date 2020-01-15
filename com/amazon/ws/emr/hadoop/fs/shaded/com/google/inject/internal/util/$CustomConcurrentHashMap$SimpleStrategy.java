package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $CustomConcurrentHashMap$SimpleStrategy<K, V>
  implements .CustomConcurrentHashMap.Strategy<K, V, .CustomConcurrentHashMap.SimpleInternalEntry<K, V>>
{
  public .CustomConcurrentHashMap.SimpleInternalEntry<K, V> newEntry(K key, int hash, .CustomConcurrentHashMap.SimpleInternalEntry<K, V> next)
  {
    return new .CustomConcurrentHashMap.SimpleInternalEntry(key, hash, null, next);
  }
  
  public .CustomConcurrentHashMap.SimpleInternalEntry<K, V> copyEntry(K key, .CustomConcurrentHashMap.SimpleInternalEntry<K, V> original, .CustomConcurrentHashMap.SimpleInternalEntry<K, V> next)
  {
    return new .CustomConcurrentHashMap.SimpleInternalEntry(key, hash, value, next);
  }
  
  public void setValue(.CustomConcurrentHashMap.SimpleInternalEntry<K, V> entry, V value)
  {
    value = value;
  }
  
  public V getValue(.CustomConcurrentHashMap.SimpleInternalEntry<K, V> entry)
  {
    return (V)value;
  }
  
  public boolean equalKeys(K a, Object b)
  {
    return a.equals(b);
  }
  
  public boolean equalValues(V a, Object b)
  {
    return a.equals(b);
  }
  
  public int hashKey(Object key)
  {
    return key.hashCode();
  }
  
  public K getKey(.CustomConcurrentHashMap.SimpleInternalEntry<K, V> entry)
  {
    return (K)key;
  }
  
  public .CustomConcurrentHashMap.SimpleInternalEntry<K, V> getNext(.CustomConcurrentHashMap.SimpleInternalEntry<K, V> entry)
  {
    return next;
  }
  
  public int getHash(.CustomConcurrentHashMap.SimpleInternalEntry<K, V> entry)
  {
    return hash;
  }
  
  public void setInternals(.CustomConcurrentHashMap.Internals<K, V, .CustomConcurrentHashMap.SimpleInternalEntry<K, V>> internals) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.SimpleStrategy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
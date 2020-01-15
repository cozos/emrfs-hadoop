package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.Serializable;

class $ImmutableEntry<K, V>
  extends .AbstractMapEntry<K, V>
  implements Serializable
{
  private final K key;
  private final V value;
  private static final long serialVersionUID = 0L;
  
  $ImmutableEntry(@.Nullable K key, @.Nullable V value)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableEntry
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
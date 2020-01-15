package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import java.util.Map.Entry;

public class MapEntry<K, V>
  implements Map.Entry<K, V>
{
  private K key;
  private V value;
  
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
    this.value = value;
    return (V)this.value;
  }
  
  public K setKey(K key)
  {
    this.key = key;
    return (K)this.key;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
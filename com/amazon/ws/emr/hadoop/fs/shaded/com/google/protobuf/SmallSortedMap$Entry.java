package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Map.Entry;

class SmallSortedMap$Entry
  implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry>
{
  private final K key;
  private V value;
  
  SmallSortedMap$Entry(Map.Entry<K, V> arg1)
  {
    this(???, (Comparable)copy.getKey(), copy.getValue());
  }
  
  SmallSortedMap$Entry(K arg1, V key)
  {
    this.key = key;
    this.value = value;
  }
  
  public K getKey()
  {
    return key;
  }
  
  public V getValue()
  {
    return (V)value;
  }
  
  public int compareTo(SmallSortedMap<K, V>.Entry other)
  {
    return getKey().compareTo(other.getKey());
  }
  
  public V setValue(V newValue)
  {
    SmallSortedMap.access$200(this$0);
    V oldValue = value;
    value = newValue;
    return oldValue;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Map.Entry)) {
      return false;
    }
    Map.Entry<?, ?> other = (Map.Entry)o;
    return (equals(key, other.getKey())) && (equals(value, other.getValue()));
  }
  
  public int hashCode()
  {
    return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
  }
  
  public String toString()
  {
    return key + "=" + value;
  }
  
  private boolean equals(Object o1, Object o2)
  {
    return o1 == null ? false : o2 == null ? true : o1.equals(o2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.SmallSortedMap.Entry
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
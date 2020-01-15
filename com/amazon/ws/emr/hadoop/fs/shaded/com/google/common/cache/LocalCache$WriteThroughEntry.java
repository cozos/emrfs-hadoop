package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.util.Map.Entry;
import javax.annotation.Nullable;

final class LocalCache$WriteThroughEntry
  implements Map.Entry<K, V>
{
  final K key;
  V value;
  
  LocalCache$WriteThroughEntry(K arg1, V key)
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
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof Map.Entry))
    {
      Map.Entry<?, ?> that = (Map.Entry)object;
      return (key.equals(that.getKey())) && (value.equals(that.getValue()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return key.hashCode() ^ value.hashCode();
  }
  
  public V setValue(V newValue)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(getKey()));String str2 = String.valueOf(String.valueOf(getValue()));return 1 + str1.length() + str2.length() + str1 + "=" + str2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.WriteThroughEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
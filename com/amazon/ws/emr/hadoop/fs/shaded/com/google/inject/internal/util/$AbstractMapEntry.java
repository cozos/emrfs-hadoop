package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Map.Entry;

public abstract class $AbstractMapEntry<K, V>
  implements Map.Entry<K, V>
{
  public abstract K getKey();
  
  public abstract V getValue();
  
  public V setValue(V value)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(@.Nullable Object object)
  {
    if ((object instanceof Map.Entry))
    {
      Map.Entry<?, ?> that = (Map.Entry)object;
      return (.Objects.equal(getKey(), that.getKey())) && (.Objects.equal(getValue(), that.getValue()));
    }
    return false;
  }
  
  public int hashCode()
  {
    K k = getKey();
    V v = getValue();
    return (k == null ? 0 : k.hashCode()) ^ (v == null ? 0 : v.hashCode());
  }
  
  public String toString()
  {
    return getKey() + "=" + getValue();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..AbstractMapEntry
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
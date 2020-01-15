package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

class Functions$ForMapWithDefault<K, V>
  implements Function<K, V>, Serializable
{
  final Map<K, ? extends V> map;
  final V defaultValue;
  private static final long serialVersionUID = 0L;
  
  Functions$ForMapWithDefault(Map<K, ? extends V> map, @Nullable V defaultValue)
  {
    this.map = ((Map)Preconditions.checkNotNull(map));
    this.defaultValue = defaultValue;
  }
  
  public V apply(@Nullable K key)
  {
    V result = map.get(key);
    return (result != null) || (map.containsKey(key)) ? result : defaultValue;
  }
  
  public boolean equals(@Nullable Object o)
  {
    if ((o instanceof ForMapWithDefault))
    {
      ForMapWithDefault<?, ?> that = (ForMapWithDefault)o;
      return (map.equals(map)) && (Objects.equal(defaultValue, defaultValue));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { map, defaultValue });
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(map));String str2 = String.valueOf(String.valueOf(defaultValue));return 23 + str1.length() + str2.length() + "forMap(" + str1 + ", defaultValue=" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Functions.ForMapWithDefault
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
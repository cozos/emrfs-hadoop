package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

class Functions$FunctionForMapNoDefault<K, V>
  implements Function<K, V>, Serializable
{
  final Map<K, V> map;
  private static final long serialVersionUID = 0L;
  
  Functions$FunctionForMapNoDefault(Map<K, V> map)
  {
    this.map = ((Map)Preconditions.checkNotNull(map));
  }
  
  public V apply(@Nullable K key)
  {
    V result = map.get(key);
    Preconditions.checkArgument((result != null) || (map.containsKey(key)), "Key '%s' not present in map", new Object[] { key });
    return result;
  }
  
  public boolean equals(@Nullable Object o)
  {
    if ((o instanceof FunctionForMapNoDefault))
    {
      FunctionForMapNoDefault<?, ?> that = (FunctionForMapNoDefault)o;
      return map.equals(map);
    }
    return false;
  }
  
  public int hashCode()
  {
    return map.hashCode();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(map));return 8 + str.length() + "forMap(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Functions.FunctionForMapNoDefault
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
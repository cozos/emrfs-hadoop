package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Map.Entry;

class $ImmutableMap$RegularImmutableMap$EntrySet<K, V>
  extends .ImmutableSet.ArrayImmutableSet<Map.Entry<K, V>>
{
  final .ImmutableMap.RegularImmutableMap<K, V> map;
  
  $ImmutableMap$RegularImmutableMap$EntrySet(.ImmutableMap.RegularImmutableMap<K, V> map)
  {
    super(.ImmutableMap.RegularImmutableMap.access$500(map));
    this.map = map;
  }
  
  public boolean contains(Object target)
  {
    if ((target instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)target;
      V mappedValue = map.get(entry.getKey());
      return (mappedValue != null) && (mappedValue.equals(entry.getValue()));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.RegularImmutableMap.EntrySet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
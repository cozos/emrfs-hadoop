package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Map.Entry;

class $ImmutableMap$RegularImmutableMap$KeySet<K, V>
  extends .ImmutableSet.TransformedImmutableSet<Map.Entry<K, V>, K>
{
  final .ImmutableMap.RegularImmutableMap<K, V> map;
  
  $ImmutableMap$RegularImmutableMap$KeySet(.ImmutableMap.RegularImmutableMap<K, V> map)
  {
    super(.ImmutableMap.RegularImmutableMap.access$500(map), .ImmutableMap.RegularImmutableMap.access$600(map));
    this.map = map;
  }
  
  K transform(Map.Entry<K, V> element)
  {
    return (K)element.getKey();
  }
  
  public boolean contains(Object target)
  {
    return map.containsKey(target);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.RegularImmutableMap.KeySet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
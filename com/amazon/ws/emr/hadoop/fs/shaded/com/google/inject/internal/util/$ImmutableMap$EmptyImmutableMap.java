package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Map;
import java.util.Map.Entry;

final class $ImmutableMap$EmptyImmutableMap
  extends .ImmutableMap<Object, Object>
{
  public Object get(Object key)
  {
    return null;
  }
  
  public int size()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean containsKey(Object key)
  {
    return false;
  }
  
  public boolean containsValue(Object value)
  {
    return false;
  }
  
  public .ImmutableSet<Map.Entry<Object, Object>> entrySet()
  {
    return .ImmutableSet.of();
  }
  
  public .ImmutableSet<Object> keySet()
  {
    return .ImmutableSet.of();
  }
  
  public .ImmutableCollection<Object> values()
  {
    return .ImmutableCollection.EMPTY_IMMUTABLE_COLLECTION;
  }
  
  public boolean equals(@.Nullable Object object)
  {
    if ((object instanceof Map))
    {
      Map<?, ?> that = (Map)object;
      return that.isEmpty();
    }
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return "{}";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.EmptyImmutableMap
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
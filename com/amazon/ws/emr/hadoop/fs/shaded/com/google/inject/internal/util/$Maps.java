package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class $Maps
{
  public static <K, V> HashMap<K, V> newHashMap()
  {
    return new HashMap();
  }
  
  public static <K, V> LinkedHashMap<K, V> newLinkedHashMap()
  {
    return new LinkedHashMap();
  }
  
  public static <K extends Comparable, V> TreeMap<K, V> newTreeMap()
  {
    return new TreeMap();
  }
  
  public static <K, V> IdentityHashMap<K, V> newIdentityHashMap()
  {
    return new IdentityHashMap();
  }
  
  public static <K, V> Map.Entry<K, V> immutableEntry(@.Nullable K key, @.Nullable V value)
  {
    return new .ImmutableEntry(key, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Maps
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

abstract class ImmutableSortedMapFauxverideShim<K, V>
  extends ImmutableMap<K, V>
{
  @Deprecated
  public static <K, V> ImmutableSortedMap.Builder<K, V> builder()
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <K, V> ImmutableSortedMap<K, V> of(K k1, V v1)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <K, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <K, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <K, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <K, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSortedMapFauxverideShim
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
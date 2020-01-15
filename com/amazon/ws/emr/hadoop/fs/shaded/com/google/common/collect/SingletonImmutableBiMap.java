package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
final class SingletonImmutableBiMap<K, V>
  extends ImmutableBiMap<K, V>
{
  final transient K singleKey;
  final transient V singleValue;
  transient ImmutableBiMap<V, K> inverse;
  
  SingletonImmutableBiMap(K singleKey, V singleValue)
  {
    CollectPreconditions.checkEntryNotNull(singleKey, singleValue);
    this.singleKey = singleKey;
    this.singleValue = singleValue;
  }
  
  private SingletonImmutableBiMap(K singleKey, V singleValue, ImmutableBiMap<V, K> inverse)
  {
    this.singleKey = singleKey;
    this.singleValue = singleValue;
    this.inverse = inverse;
  }
  
  SingletonImmutableBiMap(Map.Entry<? extends K, ? extends V> entry)
  {
    this(entry.getKey(), entry.getValue());
  }
  
  public V get(@Nullable Object key)
  {
    return (V)(singleKey.equals(key) ? singleValue : null);
  }
  
  public int size()
  {
    return 1;
  }
  
  public boolean containsKey(@Nullable Object key)
  {
    return singleKey.equals(key);
  }
  
  public boolean containsValue(@Nullable Object value)
  {
    return singleValue.equals(value);
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    return ImmutableSet.of(Maps.immutableEntry(singleKey, singleValue));
  }
  
  ImmutableSet<K> createKeySet()
  {
    return ImmutableSet.of(singleKey);
  }
  
  public ImmutableBiMap<V, K> inverse()
  {
    ImmutableBiMap<V, K> result = inverse;
    if (result == null) {
      return inverse = new SingletonImmutableBiMap(singleValue, singleKey, this);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SingletonImmutableBiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
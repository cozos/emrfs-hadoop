package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$UnmodifiableBiMap<K, V>
  extends ForwardingMap<K, V>
  implements BiMap<K, V>, Serializable
{
  final Map<K, V> unmodifiableMap;
  final BiMap<? extends K, ? extends V> delegate;
  BiMap<V, K> inverse;
  transient Set<V> values;
  private static final long serialVersionUID = 0L;
  
  Maps$UnmodifiableBiMap(BiMap<? extends K, ? extends V> delegate, @Nullable BiMap<V, K> inverse)
  {
    unmodifiableMap = Collections.unmodifiableMap(delegate);
    this.delegate = delegate;
    this.inverse = inverse;
  }
  
  protected Map<K, V> delegate()
  {
    return unmodifiableMap;
  }
  
  public V forcePut(K key, V value)
  {
    throw new UnsupportedOperationException();
  }
  
  public BiMap<V, K> inverse()
  {
    BiMap<V, K> result = inverse;
    return result == null ? (inverse = new UnmodifiableBiMap(delegate.inverse(), this)) : result;
  }
  
  public Set<V> values()
  {
    Set<V> result = values;
    return result == null ? (values = Collections.unmodifiableSet(delegate.values())) : result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.UnmodifiableBiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public abstract class ForwardingConcurrentMap<K, V>
  extends ForwardingMap<K, V>
  implements ConcurrentMap<K, V>
{
  protected abstract ConcurrentMap<K, V> delegate();
  
  public V putIfAbsent(K key, V value)
  {
    return (V)delegate().putIfAbsent(key, value);
  }
  
  public boolean remove(Object key, Object value)
  {
    return delegate().remove(key, value);
  }
  
  public V replace(K key, V value)
  {
    return (V)delegate().replace(key, value);
  }
  
  public boolean replace(K key, V oldValue, V newValue)
  {
    return delegate().replace(key, oldValue, newValue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingConcurrentMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
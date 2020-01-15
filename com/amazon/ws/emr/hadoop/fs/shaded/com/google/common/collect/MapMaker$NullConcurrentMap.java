package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

class MapMaker$NullConcurrentMap<K, V>
  extends AbstractMap<K, V>
  implements ConcurrentMap<K, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  private final MapMaker.RemovalListener<K, V> removalListener;
  private final MapMaker.RemovalCause removalCause;
  
  MapMaker$NullConcurrentMap(MapMaker mapMaker)
  {
    removalListener = mapMaker.getRemovalListener();
    removalCause = nullRemovalCause;
  }
  
  public boolean containsKey(@Nullable Object key)
  {
    return false;
  }
  
  public boolean containsValue(@Nullable Object value)
  {
    return false;
  }
  
  public V get(@Nullable Object key)
  {
    return null;
  }
  
  void notifyRemoval(K key, V value)
  {
    MapMaker.RemovalNotification<K, V> notification = new MapMaker.RemovalNotification(key, value, removalCause);
    
    removalListener.onRemoval(notification);
  }
  
  public V put(K key, V value)
  {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(value);
    notifyRemoval(key, value);
    return null;
  }
  
  public V putIfAbsent(K key, V value)
  {
    return (V)put(key, value);
  }
  
  public V remove(@Nullable Object key)
  {
    return null;
  }
  
  public boolean remove(@Nullable Object key, @Nullable Object value)
  {
    return false;
  }
  
  public V replace(K key, V value)
  {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(value);
    return null;
  }
  
  public boolean replace(K key, @Nullable V oldValue, V newValue)
  {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(newValue);
    return false;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return Collections.emptySet();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMaker.NullConcurrentMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MapConstraints$ConstrainedMap<K, V>
  extends ForwardingMap<K, V>
{
  private final Map<K, V> delegate;
  final MapConstraint<? super K, ? super V> constraint;
  private transient Set<Map.Entry<K, V>> entrySet;
  
  MapConstraints$ConstrainedMap(Map<K, V> delegate, MapConstraint<? super K, ? super V> constraint)
  {
    this.delegate = ((Map)Preconditions.checkNotNull(delegate));
    this.constraint = ((MapConstraint)Preconditions.checkNotNull(constraint));
  }
  
  protected Map<K, V> delegate()
  {
    return delegate;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set<Map.Entry<K, V>> result = entrySet;
    if (result == null) {
      entrySet = (result = MapConstraints.access$000(delegate.entrySet(), constraint));
    }
    return result;
  }
  
  public V put(K key, V value)
  {
    constraint.checkKeyValue(key, value);
    return (V)delegate.put(key, value);
  }
  
  public void putAll(Map<? extends K, ? extends V> map)
  {
    delegate.putAll(MapConstraints.access$100(map, constraint));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
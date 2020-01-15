package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedBiMap<K, V>
  extends MapConstraints.ConstrainedMap<K, V>
  implements BiMap<K, V>
{
  volatile BiMap<V, K> inverse;
  
  MapConstraints$ConstrainedBiMap(BiMap<K, V> delegate, @Nullable BiMap<V, K> inverse, MapConstraint<? super K, ? super V> constraint)
  {
    super(delegate, constraint);
    this.inverse = inverse;
  }
  
  protected BiMap<K, V> delegate()
  {
    return (BiMap)super.delegate();
  }
  
  public V forcePut(K key, V value)
  {
    constraint.checkKeyValue(key, value);
    return (V)delegate().forcePut(key, value);
  }
  
  public BiMap<V, K> inverse()
  {
    if (inverse == null) {
      inverse = new ConstrainedBiMap(delegate().inverse(), this, new MapConstraints.InverseConstraint(constraint));
    }
    return inverse;
  }
  
  public Set<V> values()
  {
    return delegate().values();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedBiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
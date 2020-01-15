package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

class MapConstraints$InverseConstraint<K, V>
  implements MapConstraint<K, V>
{
  final MapConstraint<? super V, ? super K> constraint;
  
  public MapConstraints$InverseConstraint(MapConstraint<? super V, ? super K> constraint)
  {
    this.constraint = ((MapConstraint)Preconditions.checkNotNull(constraint));
  }
  
  public void checkKeyValue(K key, V value)
  {
    constraint.checkKeyValue(value, key);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.InverseConstraint
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
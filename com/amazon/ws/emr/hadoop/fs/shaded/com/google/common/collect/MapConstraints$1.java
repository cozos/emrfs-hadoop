package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

final class MapConstraints$1
  extends ForwardingMapEntry<K, V>
{
  MapConstraints$1(Map.Entry paramEntry, MapConstraint paramMapConstraint) {}
  
  protected Map.Entry<K, V> delegate()
  {
    return val$entry;
  }
  
  public V setValue(V value)
  {
    val$constraint.checkKeyValue(getKey(), value);
    return (V)val$entry.setValue(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
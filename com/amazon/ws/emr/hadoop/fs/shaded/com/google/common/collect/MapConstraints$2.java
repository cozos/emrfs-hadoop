package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Map.Entry;

final class MapConstraints$2
  extends ForwardingMapEntry<K, Collection<V>>
{
  MapConstraints$2(Map.Entry paramEntry, MapConstraint paramMapConstraint) {}
  
  protected Map.Entry<K, Collection<V>> delegate()
  {
    return val$entry;
  }
  
  public Collection<V> getValue()
  {
    Constraints.constrainedTypePreservingCollection((Collection)val$entry.getValue(), new Constraint()
    {
      public V checkElement(V value)
      {
        val$constraint.checkKeyValue(getKey(), value);
        return value;
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedEntrySet<K, V>
  extends MapConstraints.ConstrainedEntries<K, V>
  implements Set<Map.Entry<K, V>>
{
  MapConstraints$ConstrainedEntrySet(Set<Map.Entry<K, V>> entries, MapConstraint<? super K, ? super V> constraint)
  {
    super(entries, constraint);
  }
  
  public boolean equals(@Nullable Object object)
  {
    return Sets.equalsImpl(this, object);
  }
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedEntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedAsMapValues$1
  implements Iterator<Collection<V>>
{
  MapConstraints$ConstrainedAsMapValues$1(MapConstraints.ConstrainedAsMapValues paramConstrainedAsMapValues, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$iterator.hasNext();
  }
  
  public Collection<V> next()
  {
    return (Collection)((Map.Entry)val$iterator.next()).getValue();
  }
  
  public void remove()
  {
    val$iterator.remove();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedAsMapValues.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
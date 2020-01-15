package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.clustering;

import java.util.Collection;

public abstract interface Clusterable<T>
{
  public abstract double distanceFrom(T paramT);
  
  public abstract T centroidOf(Collection<T> paramCollection);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.clustering.Clusterable
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
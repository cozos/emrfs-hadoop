package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

final class Iterables$7
  extends FluentIterable<T>
{
  Iterables$7(Iterable paramIterable, Class paramClass) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.filter(val$unfiltered.iterator(), val$type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.List;

final class Iterables$5
  extends FluentIterable<List<T>>
{
  Iterables$5(Iterable paramIterable, int paramInt) {}
  
  public Iterator<List<T>> iterator()
  {
    return Iterators.paddedPartition(val$iterable.iterator(), val$size);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
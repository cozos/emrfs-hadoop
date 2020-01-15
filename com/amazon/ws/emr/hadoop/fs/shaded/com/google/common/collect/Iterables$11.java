package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

final class Iterables$11
  extends FluentIterable<T>
{
  Iterables$11(Iterable paramIterable, int paramInt) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.limit(val$iterable.iterator(), val$limitSize);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
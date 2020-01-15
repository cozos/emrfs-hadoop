package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

final class Iterables$2
  extends FluentIterable<T>
{
  Iterables$2(Iterable paramIterable) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.concat(Iterables.access$100(val$inputs));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
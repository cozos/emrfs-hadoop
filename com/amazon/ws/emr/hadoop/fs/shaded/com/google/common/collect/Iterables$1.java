package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

final class Iterables$1
  extends FluentIterable<T>
{
  Iterables$1(Iterable paramIterable) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.cycle(val$iterable);
  }
  
  public String toString()
  {
    return String.valueOf(val$iterable.toString()).concat(" (cycled)");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
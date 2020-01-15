package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

final class Iterables$13
  extends FluentIterable<T>
{
  Iterables$13(Iterable paramIterable) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.consumingIterator(val$iterable.iterator());
  }
  
  public String toString()
  {
    return "Iterables.consumingIterable(...)";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
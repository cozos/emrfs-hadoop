package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;

final class Iterables$14
  extends FluentIterable<T>
{
  Iterables$14(Iterable paramIterable, Comparator paramComparator) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.mergeSorted(Iterables.transform(val$iterables, Iterables.access$300()), val$comparator);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
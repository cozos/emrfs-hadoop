package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Iterator;

final class Iterables$6
  extends FluentIterable<T>
{
  Iterables$6(Iterable paramIterable, Predicate paramPredicate) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.filter(val$unfiltered.iterator(), val$predicate);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

final class Iterables$UnmodifiableIterable<T>
  extends FluentIterable<T>
{
  private final Iterable<T> iterable;
  
  private Iterables$UnmodifiableIterable(Iterable<T> iterable)
  {
    this.iterable = iterable;
  }
  
  public Iterator<T> iterator()
  {
    return Iterators.unmodifiableIterator(iterable.iterator());
  }
  
  public String toString()
  {
    return iterable.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.UnmodifiableIterable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Queue;

final class Iterables$12
  extends FluentIterable<T>
{
  Iterables$12(Iterable paramIterable) {}
  
  public Iterator<T> iterator()
  {
    return new Iterables.ConsumingQueueIterator((Queue)val$iterable, null);
  }
  
  public String toString()
  {
    return "Iterables.consumingIterable(...)";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

final class Iterators$10
  extends UnmodifiableIterator<T>
{
  Iterators$10(Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$iterator.hasNext();
  }
  
  public T next()
  {
    T next = val$iterator.next();
    val$iterator.remove();
    return next;
  }
  
  public String toString()
  {
    return "Iterators.consumingIterator(...)";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
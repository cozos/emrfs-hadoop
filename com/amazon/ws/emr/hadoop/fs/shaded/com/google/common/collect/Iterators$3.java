package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

final class Iterators$3
  extends UnmodifiableIterator<T>
{
  Iterators$3(Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$iterator.hasNext();
  }
  
  public T next()
  {
    return (T)val$iterator.next();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
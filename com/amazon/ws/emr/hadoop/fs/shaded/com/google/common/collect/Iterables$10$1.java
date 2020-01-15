package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

class Iterables$10$1
  implements Iterator<T>
{
  boolean atStart = true;
  
  Iterables$10$1(Iterables.10 param10, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$iterator.hasNext();
  }
  
  public T next()
  {
    T result = val$iterator.next();
    atStart = false;
    return result;
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(!atStart);
    val$iterator.remove();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.10.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
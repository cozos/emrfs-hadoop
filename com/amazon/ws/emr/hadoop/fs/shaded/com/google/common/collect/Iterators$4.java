package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$4
  implements Iterator<T>
{
  Iterator<T> iterator = Iterators.emptyIterator();
  Iterator<T> removeFrom;
  
  Iterators$4(Iterable paramIterable) {}
  
  public boolean hasNext()
  {
    if (!iterator.hasNext()) {
      iterator = val$iterable.iterator();
    }
    return iterator.hasNext();
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    removeFrom = iterator;
    return (T)iterator.next();
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(removeFrom != null);
    removeFrom.remove();
    removeFrom = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
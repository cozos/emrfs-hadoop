package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class $Iterators$4
  implements Iterator<T>
{
  Iterator<? extends T> current = .Iterators.emptyIterator();
  Iterator<? extends T> removeFrom;
  
  $Iterators$4(Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    while ((!current.hasNext()) && (val$inputs.hasNext())) {
      current = ((Iterator)val$inputs.next());
    }
    return current.hasNext();
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    removeFrom = current;
    return (T)current.next();
  }
  
  public void remove()
  {
    .Preconditions.checkState(removeFrom != null, "no calls to next() since last call to remove()");
    
    removeFrom.remove();
    removeFrom = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterators.4
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
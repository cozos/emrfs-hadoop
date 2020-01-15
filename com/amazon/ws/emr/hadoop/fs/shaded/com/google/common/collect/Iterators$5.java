package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$5
  implements Iterator<T>
{
  Iterator<? extends T> current = Iterators.emptyIterator();
  Iterator<? extends T> removeFrom;
  
  Iterators$5(Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    boolean currentHasNext;
    while ((!(currentHasNext = ((Iterator)Preconditions.checkNotNull(current)).hasNext())) && (val$inputs.hasNext())) {
      current = ((Iterator)val$inputs.next());
    }
    return currentHasNext;
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
    CollectPreconditions.checkRemove(removeFrom != null);
    removeFrom.remove();
    removeFrom = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
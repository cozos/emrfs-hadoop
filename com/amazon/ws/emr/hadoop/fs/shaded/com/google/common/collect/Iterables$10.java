package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

final class Iterables$10
  extends FluentIterable<T>
{
  Iterables$10(Iterable paramIterable, int paramInt) {}
  
  public Iterator<T> iterator()
  {
    final Iterator<T> iterator = val$iterable.iterator();
    
    Iterators.advance(iterator, val$numberToSkip);
    
    new Iterator()
    {
      boolean atStart = true;
      
      public boolean hasNext()
      {
        return iterator.hasNext();
      }
      
      public T next()
      {
        T result = iterator.next();
        atStart = false;
        return result;
      }
      
      public void remove()
      {
        CollectPreconditions.checkRemove(!atStart);
        iterator.remove();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$9
  implements Iterator<T>
{
  private int count;
  
  Iterators$9(int paramInt, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return (count < val$limitSize) && (val$iterator.hasNext());
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    count += 1;
    return (T)val$iterator.next();
  }
  
  public void remove()
  {
    val$iterator.remove();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
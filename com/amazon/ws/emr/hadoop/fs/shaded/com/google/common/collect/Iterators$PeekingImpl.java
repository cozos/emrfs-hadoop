package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;

class Iterators$PeekingImpl<E>
  implements PeekingIterator<E>
{
  private final Iterator<? extends E> iterator;
  private boolean hasPeeked;
  private E peekedElement;
  
  public Iterators$PeekingImpl(Iterator<? extends E> iterator)
  {
    this.iterator = ((Iterator)Preconditions.checkNotNull(iterator));
  }
  
  public boolean hasNext()
  {
    return (hasPeeked) || (iterator.hasNext());
  }
  
  public E next()
  {
    if (!hasPeeked) {
      return (E)iterator.next();
    }
    E result = peekedElement;
    hasPeeked = false;
    peekedElement = null;
    return result;
  }
  
  public void remove()
  {
    Preconditions.checkState(!hasPeeked, "Can't remove after you've peeked at next");
    iterator.remove();
  }
  
  public E peek()
  {
    if (!hasPeeked)
    {
      peekedElement = iterator.next();
      hasPeeked = true;
    }
    return (E)peekedElement;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.PeekingImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
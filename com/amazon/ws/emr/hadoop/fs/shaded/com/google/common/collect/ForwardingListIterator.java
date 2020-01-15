package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible
public abstract class ForwardingListIterator<E>
  extends ForwardingIterator<E>
  implements ListIterator<E>
{
  protected abstract ListIterator<E> delegate();
  
  public void add(E element)
  {
    delegate().add(element);
  }
  
  public boolean hasPrevious()
  {
    return delegate().hasPrevious();
  }
  
  public int nextIndex()
  {
    return delegate().nextIndex();
  }
  
  public E previous()
  {
    return (E)delegate().previous();
  }
  
  public int previousIndex()
  {
    return delegate().previousIndex();
  }
  
  public void set(E element)
  {
    delegate().set(element);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingListIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
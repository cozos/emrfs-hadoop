package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import java.util.Queue;

@GwtCompatible
public abstract class ForwardingQueue<E>
  extends ForwardingCollection<E>
  implements Queue<E>
{
  protected abstract Queue<E> delegate();
  
  public boolean offer(E o)
  {
    return delegate().offer(o);
  }
  
  public E poll()
  {
    return (E)delegate().poll();
  }
  
  public E remove()
  {
    return (E)delegate().remove();
  }
  
  public E peek()
  {
    return (E)delegate().peek();
  }
  
  public E element()
  {
    return (E)delegate().element();
  }
  
  protected boolean standardOffer(E e)
  {
    try
    {
      return add(e);
    }
    catch (IllegalStateException caught) {}
    return false;
  }
  
  protected E standardPeek()
  {
    try
    {
      return (E)element();
    }
    catch (NoSuchElementException caught) {}
    return null;
  }
  
  protected E standardPoll()
  {
    try
    {
      return (E)remove();
    }
    catch (NoSuchElementException caught) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
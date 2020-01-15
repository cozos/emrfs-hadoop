package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingBlockingDeque<E>
  extends ForwardingDeque<E>
  implements BlockingDeque<E>
{
  protected abstract BlockingDeque<E> delegate();
  
  public int remainingCapacity()
  {
    return delegate().remainingCapacity();
  }
  
  public void putFirst(E e)
    throws InterruptedException
  {
    delegate().putFirst(e);
  }
  
  public void putLast(E e)
    throws InterruptedException
  {
    delegate().putLast(e);
  }
  
  public boolean offerFirst(E e, long timeout, TimeUnit unit)
    throws InterruptedException
  {
    return delegate().offerFirst(e, timeout, unit);
  }
  
  public boolean offerLast(E e, long timeout, TimeUnit unit)
    throws InterruptedException
  {
    return delegate().offerLast(e, timeout, unit);
  }
  
  public E takeFirst()
    throws InterruptedException
  {
    return (E)delegate().takeFirst();
  }
  
  public E takeLast()
    throws InterruptedException
  {
    return (E)delegate().takeLast();
  }
  
  public E pollFirst(long timeout, TimeUnit unit)
    throws InterruptedException
  {
    return (E)delegate().pollFirst(timeout, unit);
  }
  
  public E pollLast(long timeout, TimeUnit unit)
    throws InterruptedException
  {
    return (E)delegate().pollLast(timeout, unit);
  }
  
  public void put(E e)
    throws InterruptedException
  {
    delegate().put(e);
  }
  
  public boolean offer(E e, long timeout, TimeUnit unit)
    throws InterruptedException
  {
    return delegate().offer(e, timeout, unit);
  }
  
  public E take()
    throws InterruptedException
  {
    return (E)delegate().take();
  }
  
  public E poll(long timeout, TimeUnit unit)
    throws InterruptedException
  {
    return (E)delegate().poll(timeout, unit);
  }
  
  public int drainTo(Collection<? super E> c)
  {
    return delegate().drainTo(c);
  }
  
  public int drainTo(Collection<? super E> c, int maxElements)
  {
    return delegate().drainTo(c, maxElements);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingBlockingDeque
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
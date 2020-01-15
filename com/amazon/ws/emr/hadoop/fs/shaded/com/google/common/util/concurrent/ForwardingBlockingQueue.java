package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingQueue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingBlockingQueue<E>
  extends ForwardingQueue<E>
  implements BlockingQueue<E>
{
  protected abstract BlockingQueue<E> delegate();
  
  public int drainTo(Collection<? super E> c, int maxElements)
  {
    return delegate().drainTo(c, maxElements);
  }
  
  public int drainTo(Collection<? super E> c)
  {
    return delegate().drainTo(c);
  }
  
  public boolean offer(E e, long timeout, TimeUnit unit)
    throws InterruptedException
  {
    return delegate().offer(e, timeout, unit);
  }
  
  public E poll(long timeout, TimeUnit unit)
    throws InterruptedException
  {
    return (E)delegate().poll(timeout, unit);
  }
  
  public void put(E e)
    throws InterruptedException
  {
    delegate().put(e);
  }
  
  public int remainingCapacity()
  {
    return delegate().remainingCapacity();
  }
  
  public E take()
    throws InterruptedException
  {
    return (E)delegate().take();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ForwardingBlockingQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
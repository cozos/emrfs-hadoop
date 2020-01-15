package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Deque;
import java.util.Iterator;

public abstract class ForwardingDeque<E>
  extends ForwardingQueue<E>
  implements Deque<E>
{
  protected abstract Deque<E> delegate();
  
  public void addFirst(E e)
  {
    delegate().addFirst(e);
  }
  
  public void addLast(E e)
  {
    delegate().addLast(e);
  }
  
  public Iterator<E> descendingIterator()
  {
    return delegate().descendingIterator();
  }
  
  public E getFirst()
  {
    return (E)delegate().getFirst();
  }
  
  public E getLast()
  {
    return (E)delegate().getLast();
  }
  
  public boolean offerFirst(E e)
  {
    return delegate().offerFirst(e);
  }
  
  public boolean offerLast(E e)
  {
    return delegate().offerLast(e);
  }
  
  public E peekFirst()
  {
    return (E)delegate().peekFirst();
  }
  
  public E peekLast()
  {
    return (E)delegate().peekLast();
  }
  
  public E pollFirst()
  {
    return (E)delegate().pollFirst();
  }
  
  public E pollLast()
  {
    return (E)delegate().pollLast();
  }
  
  public E pop()
  {
    return (E)delegate().pop();
  }
  
  public void push(E e)
  {
    delegate().push(e);
  }
  
  public E removeFirst()
  {
    return (E)delegate().removeFirst();
  }
  
  public E removeLast()
  {
    return (E)delegate().removeLast();
  }
  
  public boolean removeFirstOccurrence(Object o)
  {
    return delegate().removeFirstOccurrence(o);
  }
  
  public boolean removeLastOccurrence(Object o)
  {
    return delegate().removeLastOccurrence(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingDeque
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
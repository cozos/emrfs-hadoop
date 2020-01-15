package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ListIterator;

class Constraints$ConstrainedListIterator<E>
  extends ForwardingListIterator<E>
{
  private final ListIterator<E> delegate;
  private final Constraint<? super E> constraint;
  
  public Constraints$ConstrainedListIterator(ListIterator<E> delegate, Constraint<? super E> constraint)
  {
    this.delegate = delegate;
    this.constraint = constraint;
  }
  
  protected ListIterator<E> delegate()
  {
    return delegate;
  }
  
  public void add(E element)
  {
    constraint.checkElement(element);
    delegate.add(element);
  }
  
  public void set(E element)
  {
    constraint.checkElement(element);
    delegate.set(element);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Constraints.ConstrainedListIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
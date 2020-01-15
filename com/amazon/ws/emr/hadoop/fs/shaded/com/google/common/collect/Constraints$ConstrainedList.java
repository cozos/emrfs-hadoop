package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

@GwtCompatible
class Constraints$ConstrainedList<E>
  extends ForwardingList<E>
{
  final List<E> delegate;
  final Constraint<? super E> constraint;
  
  Constraints$ConstrainedList(List<E> delegate, Constraint<? super E> constraint)
  {
    this.delegate = ((List)Preconditions.checkNotNull(delegate));
    this.constraint = ((Constraint)Preconditions.checkNotNull(constraint));
  }
  
  protected List<E> delegate()
  {
    return delegate;
  }
  
  public boolean add(E element)
  {
    constraint.checkElement(element);
    return delegate.add(element);
  }
  
  public void add(int index, E element)
  {
    constraint.checkElement(element);
    delegate.add(index, element);
  }
  
  public boolean addAll(Collection<? extends E> elements)
  {
    return delegate.addAll(Constraints.access$000(elements, constraint));
  }
  
  public boolean addAll(int index, Collection<? extends E> elements)
  {
    return delegate.addAll(index, Constraints.access$000(elements, constraint));
  }
  
  public ListIterator<E> listIterator()
  {
    return Constraints.access$100(delegate.listIterator(), constraint);
  }
  
  public ListIterator<E> listIterator(int index)
  {
    return Constraints.access$100(delegate.listIterator(index), constraint);
  }
  
  public E set(int index, E element)
  {
    constraint.checkElement(element);
    return (E)delegate.set(index, element);
  }
  
  public List<E> subList(int fromIndex, int toIndex)
  {
    return Constraints.constrainedList(delegate.subList(fromIndex, toIndex), constraint);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Constraints.ConstrainedList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
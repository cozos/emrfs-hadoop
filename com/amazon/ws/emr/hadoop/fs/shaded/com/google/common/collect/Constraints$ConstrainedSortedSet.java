package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.SortedSet;

class Constraints$ConstrainedSortedSet<E>
  extends ForwardingSortedSet<E>
{
  final SortedSet<E> delegate;
  final Constraint<? super E> constraint;
  
  Constraints$ConstrainedSortedSet(SortedSet<E> delegate, Constraint<? super E> constraint)
  {
    this.delegate = ((SortedSet)Preconditions.checkNotNull(delegate));
    this.constraint = ((Constraint)Preconditions.checkNotNull(constraint));
  }
  
  protected SortedSet<E> delegate()
  {
    return delegate;
  }
  
  public SortedSet<E> headSet(E toElement)
  {
    return Constraints.constrainedSortedSet(delegate.headSet(toElement), constraint);
  }
  
  public SortedSet<E> subSet(E fromElement, E toElement)
  {
    return Constraints.constrainedSortedSet(delegate.subSet(fromElement, toElement), constraint);
  }
  
  public SortedSet<E> tailSet(E fromElement)
  {
    return Constraints.constrainedSortedSet(delegate.tailSet(fromElement), constraint);
  }
  
  public boolean add(E element)
  {
    constraint.checkElement(element);
    return delegate.add(element);
  }
  
  public boolean addAll(Collection<? extends E> elements)
  {
    return delegate.addAll(Constraints.access$000(elements, constraint));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Constraints.ConstrainedSortedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
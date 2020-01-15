package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;

class Constraints$ConstrainedCollection<E>
  extends ForwardingCollection<E>
{
  private final Collection<E> delegate;
  private final Constraint<? super E> constraint;
  
  public Constraints$ConstrainedCollection(Collection<E> delegate, Constraint<? super E> constraint)
  {
    this.delegate = ((Collection)Preconditions.checkNotNull(delegate));
    this.constraint = ((Constraint)Preconditions.checkNotNull(constraint));
  }
  
  protected Collection<E> delegate()
  {
    return delegate;
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Constraints.ConstrainedCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
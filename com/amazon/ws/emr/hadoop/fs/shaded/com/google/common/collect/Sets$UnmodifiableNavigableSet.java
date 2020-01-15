package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtIncompatible("NavigableSet")
final class Sets$UnmodifiableNavigableSet<E>
  extends ForwardingSortedSet<E>
  implements NavigableSet<E>, Serializable
{
  private final NavigableSet<E> delegate;
  private transient UnmodifiableNavigableSet<E> descendingSet;
  private static final long serialVersionUID = 0L;
  
  Sets$UnmodifiableNavigableSet(NavigableSet<E> delegate)
  {
    this.delegate = ((NavigableSet)Preconditions.checkNotNull(delegate));
  }
  
  protected SortedSet<E> delegate()
  {
    return Collections.unmodifiableSortedSet(delegate);
  }
  
  public E lower(E e)
  {
    return (E)delegate.lower(e);
  }
  
  public E floor(E e)
  {
    return (E)delegate.floor(e);
  }
  
  public E ceiling(E e)
  {
    return (E)delegate.ceiling(e);
  }
  
  public E higher(E e)
  {
    return (E)delegate.higher(e);
  }
  
  public E pollFirst()
  {
    throw new UnsupportedOperationException();
  }
  
  public E pollLast()
  {
    throw new UnsupportedOperationException();
  }
  
  public NavigableSet<E> descendingSet()
  {
    UnmodifiableNavigableSet<E> result = descendingSet;
    if (result == null)
    {
      result = descendingSet = new UnmodifiableNavigableSet(delegate.descendingSet());
      
      descendingSet = this;
    }
    return result;
  }
  
  public Iterator<E> descendingIterator()
  {
    return Iterators.unmodifiableIterator(delegate.descendingIterator());
  }
  
  public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
  {
    return Sets.unmodifiableNavigableSet(delegate.subSet(fromElement, fromInclusive, toElement, toInclusive));
  }
  
  public NavigableSet<E> headSet(E toElement, boolean inclusive)
  {
    return Sets.unmodifiableNavigableSet(delegate.headSet(toElement, inclusive));
  }
  
  public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
  {
    return Sets.unmodifiableNavigableSet(delegate.tailSet(fromElement, inclusive));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.UnmodifiableNavigableSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableSet")
class Sets$FilteredNavigableSet<E>
  extends Sets.FilteredSortedSet<E>
  implements NavigableSet<E>
{
  Sets$FilteredNavigableSet(NavigableSet<E> unfiltered, Predicate<? super E> predicate)
  {
    super(unfiltered, predicate);
  }
  
  NavigableSet<E> unfiltered()
  {
    return (NavigableSet)unfiltered;
  }
  
  @Nullable
  public E lower(E e)
  {
    return (E)Iterators.getNext(headSet(e, false).descendingIterator(), null);
  }
  
  @Nullable
  public E floor(E e)
  {
    return (E)Iterators.getNext(headSet(e, true).descendingIterator(), null);
  }
  
  public E ceiling(E e)
  {
    return (E)Iterables.getFirst(tailSet(e, true), null);
  }
  
  public E higher(E e)
  {
    return (E)Iterables.getFirst(tailSet(e, false), null);
  }
  
  public E pollFirst()
  {
    return (E)Iterables.removeFirstMatching(unfiltered(), predicate);
  }
  
  public E pollLast()
  {
    return (E)Iterables.removeFirstMatching(unfiltered().descendingSet(), predicate);
  }
  
  public NavigableSet<E> descendingSet()
  {
    return Sets.filter(unfiltered().descendingSet(), predicate);
  }
  
  public Iterator<E> descendingIterator()
  {
    return Iterators.filter(unfiltered().descendingIterator(), predicate);
  }
  
  public E last()
  {
    return (E)descendingIterator().next();
  }
  
  public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
  {
    return Sets.filter(unfiltered().subSet(fromElement, fromInclusive, toElement, toInclusive), predicate);
  }
  
  public NavigableSet<E> headSet(E toElement, boolean inclusive)
  {
    return Sets.filter(unfiltered().headSet(toElement, inclusive), predicate);
  }
  
  public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
  {
    return Sets.filter(unfiltered().tailSet(fromElement, inclusive), predicate);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.FilteredNavigableSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
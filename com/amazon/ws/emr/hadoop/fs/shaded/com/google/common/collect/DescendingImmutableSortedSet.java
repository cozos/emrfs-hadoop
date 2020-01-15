package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

class DescendingImmutableSortedSet<E>
  extends ImmutableSortedSet<E>
{
  private final ImmutableSortedSet<E> forward;
  
  DescendingImmutableSortedSet(ImmutableSortedSet<E> forward)
  {
    super(Ordering.from(forward.comparator()).reverse());
    this.forward = forward;
  }
  
  public int size()
  {
    return forward.size();
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return forward.descendingIterator();
  }
  
  ImmutableSortedSet<E> headSetImpl(E toElement, boolean inclusive)
  {
    return forward.tailSet(toElement, inclusive).descendingSet();
  }
  
  ImmutableSortedSet<E> subSetImpl(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
  {
    return forward.subSet(toElement, toInclusive, fromElement, fromInclusive).descendingSet();
  }
  
  ImmutableSortedSet<E> tailSetImpl(E fromElement, boolean inclusive)
  {
    return forward.headSet(fromElement, inclusive).descendingSet();
  }
  
  @GwtIncompatible("NavigableSet")
  public ImmutableSortedSet<E> descendingSet()
  {
    return forward;
  }
  
  @GwtIncompatible("NavigableSet")
  public UnmodifiableIterator<E> descendingIterator()
  {
    return forward.iterator();
  }
  
  @GwtIncompatible("NavigableSet")
  ImmutableSortedSet<E> createDescendingSet()
  {
    throw new AssertionError("should never be called");
  }
  
  public E lower(E element)
  {
    return (E)forward.higher(element);
  }
  
  public E floor(E element)
  {
    return (E)forward.ceiling(element);
  }
  
  public E ceiling(E element)
  {
    return (E)forward.floor(element);
  }
  
  public E higher(E element)
  {
    return (E)forward.lower(element);
  }
  
  int indexOf(@Nullable Object target)
  {
    int index = forward.indexOf(target);
    if (index == -1) {
      return index;
    }
    return size() - 1 - index;
  }
  
  boolean isPartialView()
  {
    return forward.isPartialView();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DescendingImmutableSortedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
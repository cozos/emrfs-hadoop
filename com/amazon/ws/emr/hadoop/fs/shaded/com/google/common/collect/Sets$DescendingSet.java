package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtIncompatible("NavigableSet")
class Sets$DescendingSet<E>
  extends ForwardingNavigableSet<E>
{
  private final NavigableSet<E> forward;
  
  Sets$DescendingSet(NavigableSet<E> forward)
  {
    this.forward = forward;
  }
  
  protected NavigableSet<E> delegate()
  {
    return forward;
  }
  
  public E lower(E e)
  {
    return (E)forward.higher(e);
  }
  
  public E floor(E e)
  {
    return (E)forward.ceiling(e);
  }
  
  public E ceiling(E e)
  {
    return (E)forward.floor(e);
  }
  
  public E higher(E e)
  {
    return (E)forward.lower(e);
  }
  
  public E pollFirst()
  {
    return (E)forward.pollLast();
  }
  
  public E pollLast()
  {
    return (E)forward.pollFirst();
  }
  
  public NavigableSet<E> descendingSet()
  {
    return forward;
  }
  
  public Iterator<E> descendingIterator()
  {
    return forward.iterator();
  }
  
  public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
  {
    return forward.subSet(toElement, toInclusive, fromElement, fromInclusive).descendingSet();
  }
  
  public NavigableSet<E> headSet(E toElement, boolean inclusive)
  {
    return forward.tailSet(toElement, inclusive).descendingSet();
  }
  
  public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
  {
    return forward.headSet(fromElement, inclusive).descendingSet();
  }
  
  public Comparator<? super E> comparator()
  {
    Comparator<? super E> forwardComparator = forward.comparator();
    if (forwardComparator == null) {
      return Ordering.natural().reverse();
    }
    return reverse(forwardComparator);
  }
  
  private static <T> Ordering<T> reverse(Comparator<T> forward)
  {
    return Ordering.from(forward).reverse();
  }
  
  public E first()
  {
    return (E)forward.last();
  }
  
  public SortedSet<E> headSet(E toElement)
  {
    return standardHeadSet(toElement);
  }
  
  public E last()
  {
    return (E)forward.first();
  }
  
  public SortedSet<E> subSet(E fromElement, E toElement)
  {
    return standardSubSet(fromElement, toElement);
  }
  
  public SortedSet<E> tailSet(E fromElement)
  {
    return standardTailSet(fromElement);
  }
  
  public Iterator<E> iterator()
  {
    return forward.descendingIterator();
  }
  
  public Object[] toArray()
  {
    return standardToArray();
  }
  
  public <T> T[] toArray(T[] array)
  {
    return standardToArray(array);
  }
  
  public String toString()
  {
    return standardToString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.DescendingSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
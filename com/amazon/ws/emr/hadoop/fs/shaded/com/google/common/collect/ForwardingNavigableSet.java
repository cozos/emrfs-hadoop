package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public abstract class ForwardingNavigableSet<E>
  extends ForwardingSortedSet<E>
  implements NavigableSet<E>
{
  protected abstract NavigableSet<E> delegate();
  
  public E lower(E e)
  {
    return (E)delegate().lower(e);
  }
  
  protected E standardLower(E e)
  {
    return (E)Iterators.getNext(headSet(e, false).descendingIterator(), null);
  }
  
  public E floor(E e)
  {
    return (E)delegate().floor(e);
  }
  
  protected E standardFloor(E e)
  {
    return (E)Iterators.getNext(headSet(e, true).descendingIterator(), null);
  }
  
  public E ceiling(E e)
  {
    return (E)delegate().ceiling(e);
  }
  
  protected E standardCeiling(E e)
  {
    return (E)Iterators.getNext(tailSet(e, true).iterator(), null);
  }
  
  public E higher(E e)
  {
    return (E)delegate().higher(e);
  }
  
  protected E standardHigher(E e)
  {
    return (E)Iterators.getNext(tailSet(e, false).iterator(), null);
  }
  
  public E pollFirst()
  {
    return (E)delegate().pollFirst();
  }
  
  protected E standardPollFirst()
  {
    return (E)Iterators.pollNext(iterator());
  }
  
  public E pollLast()
  {
    return (E)delegate().pollLast();
  }
  
  protected E standardPollLast()
  {
    return (E)Iterators.pollNext(descendingIterator());
  }
  
  protected E standardFirst()
  {
    return (E)iterator().next();
  }
  
  protected E standardLast()
  {
    return (E)descendingIterator().next();
  }
  
  public NavigableSet<E> descendingSet()
  {
    return delegate().descendingSet();
  }
  
  @Beta
  protected class StandardDescendingSet
    extends Sets.DescendingSet<E>
  {
    public StandardDescendingSet()
    {
      super();
    }
  }
  
  public Iterator<E> descendingIterator()
  {
    return delegate().descendingIterator();
  }
  
  public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
  {
    return delegate().subSet(fromElement, fromInclusive, toElement, toInclusive);
  }
  
  @Beta
  protected NavigableSet<E> standardSubSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
  {
    return tailSet(fromElement, fromInclusive).headSet(toElement, toInclusive);
  }
  
  protected SortedSet<E> standardSubSet(E fromElement, E toElement)
  {
    return subSet(fromElement, true, toElement, false);
  }
  
  public NavigableSet<E> headSet(E toElement, boolean inclusive)
  {
    return delegate().headSet(toElement, inclusive);
  }
  
  protected SortedSet<E> standardHeadSet(E toElement)
  {
    return headSet(toElement, false);
  }
  
  public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
  {
    return delegate().tailSet(fromElement, inclusive);
  }
  
  protected SortedSet<E> standardTailSet(E fromElement)
  {
    return tailSet(fromElement, true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingNavigableSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
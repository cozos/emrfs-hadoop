package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

class Sets$FilteredSortedSet<E>
  extends Sets.FilteredSet<E>
  implements SortedSet<E>
{
  Sets$FilteredSortedSet(SortedSet<E> unfiltered, Predicate<? super E> predicate)
  {
    super(unfiltered, predicate);
  }
  
  public Comparator<? super E> comparator()
  {
    return ((SortedSet)unfiltered).comparator();
  }
  
  public SortedSet<E> subSet(E fromElement, E toElement)
  {
    return new FilteredSortedSet(((SortedSet)unfiltered).subSet(fromElement, toElement), predicate);
  }
  
  public SortedSet<E> headSet(E toElement)
  {
    return new FilteredSortedSet(((SortedSet)unfiltered).headSet(toElement), predicate);
  }
  
  public SortedSet<E> tailSet(E fromElement)
  {
    return new FilteredSortedSet(((SortedSet)unfiltered).tailSet(fromElement), predicate);
  }
  
  public E first()
  {
    return (E)iterator().next();
  }
  
  public E last()
  {
    SortedSet<E> sortedUnfiltered = (SortedSet)unfiltered;
    for (;;)
    {
      E element = sortedUnfiltered.last();
      if (predicate.apply(element)) {
        return element;
      }
      sortedUnfiltered = sortedUnfiltered.headSet(element);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.FilteredSortedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
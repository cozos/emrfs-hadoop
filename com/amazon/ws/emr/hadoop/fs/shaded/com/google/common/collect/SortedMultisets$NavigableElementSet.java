package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.NavigableSet;

@GwtIncompatible("Navigable")
class SortedMultisets$NavigableElementSet<E>
  extends SortedMultisets.ElementSet<E>
  implements NavigableSet<E>
{
  SortedMultisets$NavigableElementSet(SortedMultiset<E> multiset)
  {
    super(multiset);
  }
  
  public E lower(E e)
  {
    return (E)SortedMultisets.access$100(multiset().headMultiset(e, BoundType.OPEN).lastEntry());
  }
  
  public E floor(E e)
  {
    return (E)SortedMultisets.access$100(multiset().headMultiset(e, BoundType.CLOSED).lastEntry());
  }
  
  public E ceiling(E e)
  {
    return (E)SortedMultisets.access$100(multiset().tailMultiset(e, BoundType.CLOSED).firstEntry());
  }
  
  public E higher(E e)
  {
    return (E)SortedMultisets.access$100(multiset().tailMultiset(e, BoundType.OPEN).firstEntry());
  }
  
  public NavigableSet<E> descendingSet()
  {
    return new NavigableElementSet(multiset().descendingMultiset());
  }
  
  public Iterator<E> descendingIterator()
  {
    return descendingSet().iterator();
  }
  
  public E pollFirst()
  {
    return (E)SortedMultisets.access$100(multiset().pollFirstEntry());
  }
  
  public E pollLast()
  {
    return (E)SortedMultisets.access$100(multiset().pollLastEntry());
  }
  
  public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
  {
    return new NavigableElementSet(multiset().subMultiset(fromElement, BoundType.forBoolean(fromInclusive), toElement, BoundType.forBoolean(toInclusive)));
  }
  
  public NavigableSet<E> headSet(E toElement, boolean inclusive)
  {
    return new NavigableElementSet(multiset().headMultiset(toElement, BoundType.forBoolean(inclusive)));
  }
  
  public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
  {
    return new NavigableElementSet(multiset().tailMultiset(fromElement, BoundType.forBoolean(inclusive)));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SortedMultisets.NavigableElementSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
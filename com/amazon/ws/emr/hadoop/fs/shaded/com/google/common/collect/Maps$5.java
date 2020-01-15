package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.NavigableSet;
import java.util.SortedSet;

final class Maps$5
  extends ForwardingNavigableSet<E>
{
  Maps$5(NavigableSet paramNavigableSet) {}
  
  protected NavigableSet<E> delegate()
  {
    return val$set;
  }
  
  public boolean add(E element)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends E> es)
  {
    throw new UnsupportedOperationException();
  }
  
  public SortedSet<E> headSet(E toElement)
  {
    return Maps.access$300(super.headSet(toElement));
  }
  
  public SortedSet<E> subSet(E fromElement, E toElement)
  {
    return Maps.access$300(super.subSet(fromElement, toElement));
  }
  
  public SortedSet<E> tailSet(E fromElement)
  {
    return Maps.access$300(super.tailSet(fromElement));
  }
  
  public NavigableSet<E> headSet(E toElement, boolean inclusive)
  {
    return Maps.access$400(super.headSet(toElement, inclusive));
  }
  
  public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
  {
    return Maps.access$400(super.tailSet(fromElement, inclusive));
  }
  
  public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
  {
    return Maps.access$400(super.subSet(fromElement, fromInclusive, toElement, toInclusive));
  }
  
  public NavigableSet<E> descendingSet()
  {
    return Maps.access$400(super.descendingSet());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
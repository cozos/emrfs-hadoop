package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.SortedSet;

final class Maps$4
  extends ForwardingSortedSet<E>
{
  Maps$4(SortedSet paramSortedSet) {}
  
  protected SortedSet<E> delegate()
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

final class DescendingImmutableSortedMultiset<E>
  extends ImmutableSortedMultiset<E>
{
  private final transient ImmutableSortedMultiset<E> forward;
  
  DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> forward)
  {
    this.forward = forward;
  }
  
  public int count(@Nullable Object element)
  {
    return forward.count(element);
  }
  
  public Multiset.Entry<E> firstEntry()
  {
    return forward.lastEntry();
  }
  
  public Multiset.Entry<E> lastEntry()
  {
    return forward.firstEntry();
  }
  
  public int size()
  {
    return forward.size();
  }
  
  public ImmutableSortedSet<E> elementSet()
  {
    return forward.elementSet().descendingSet();
  }
  
  Multiset.Entry<E> getEntry(int index)
  {
    return (Multiset.Entry)forward.entrySet().asList().reverse().get(index);
  }
  
  public ImmutableSortedMultiset<E> descendingMultiset()
  {
    return forward;
  }
  
  public ImmutableSortedMultiset<E> headMultiset(E upperBound, BoundType boundType)
  {
    return forward.tailMultiset(upperBound, boundType).descendingMultiset();
  }
  
  public ImmutableSortedMultiset<E> tailMultiset(E lowerBound, BoundType boundType)
  {
    return forward.headMultiset(lowerBound, boundType).descendingMultiset();
  }
  
  boolean isPartialView()
  {
    return forward.isPartialView();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DescendingImmutableSortedMultiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
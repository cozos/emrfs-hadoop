package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import javax.annotation.Nullable;

final class EmptyImmutableSortedMultiset<E>
  extends ImmutableSortedMultiset<E>
{
  private final ImmutableSortedSet<E> elementSet;
  
  EmptyImmutableSortedMultiset(Comparator<? super E> comparator)
  {
    elementSet = ImmutableSortedSet.emptySet(comparator);
  }
  
  public Multiset.Entry<E> firstEntry()
  {
    return null;
  }
  
  public Multiset.Entry<E> lastEntry()
  {
    return null;
  }
  
  public int count(@Nullable Object element)
  {
    return 0;
  }
  
  public boolean containsAll(Collection<?> targets)
  {
    return targets.isEmpty();
  }
  
  public int size()
  {
    return 0;
  }
  
  public ImmutableSortedSet<E> elementSet()
  {
    return elementSet;
  }
  
  Multiset.Entry<E> getEntry(int index)
  {
    throw new AssertionError("should never be called");
  }
  
  public ImmutableSortedMultiset<E> headMultiset(E upperBound, BoundType boundType)
  {
    Preconditions.checkNotNull(upperBound);
    Preconditions.checkNotNull(boundType);
    return this;
  }
  
  public ImmutableSortedMultiset<E> tailMultiset(E lowerBound, BoundType boundType)
  {
    Preconditions.checkNotNull(lowerBound);
    Preconditions.checkNotNull(boundType);
    return this;
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.emptyIterator();
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof Multiset))
    {
      Multiset<?> other = (Multiset)object;
      return other.isEmpty();
    }
    return false;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  int copyIntoArray(Object[] dst, int offset)
  {
    return offset;
  }
  
  public ImmutableList<E> asList()
  {
    return ImmutableList.of();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.EmptyImmutableSortedMultiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
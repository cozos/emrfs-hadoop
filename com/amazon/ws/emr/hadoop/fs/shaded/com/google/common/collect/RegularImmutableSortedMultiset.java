package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Ints;
import javax.annotation.Nullable;

final class RegularImmutableSortedMultiset<E>
  extends ImmutableSortedMultiset<E>
{
  private final transient RegularImmutableSortedSet<E> elementSet;
  private final transient int[] counts;
  private final transient long[] cumulativeCounts;
  private final transient int offset;
  private final transient int length;
  
  RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> elementSet, int[] counts, long[] cumulativeCounts, int offset, int length)
  {
    this.elementSet = elementSet;
    this.counts = counts;
    this.cumulativeCounts = cumulativeCounts;
    this.offset = offset;
    this.length = length;
  }
  
  Multiset.Entry<E> getEntry(int index)
  {
    return Multisets.immutableEntry(elementSet.asList().get(index), counts[(offset + index)]);
  }
  
  public Multiset.Entry<E> firstEntry()
  {
    return getEntry(0);
  }
  
  public Multiset.Entry<E> lastEntry()
  {
    return getEntry(length - 1);
  }
  
  public int count(@Nullable Object element)
  {
    int index = elementSet.indexOf(element);
    return index == -1 ? 0 : counts[(index + offset)];
  }
  
  public int size()
  {
    long size = cumulativeCounts[(offset + length)] - cumulativeCounts[offset];
    return Ints.saturatedCast(size);
  }
  
  public ImmutableSortedSet<E> elementSet()
  {
    return elementSet;
  }
  
  public ImmutableSortedMultiset<E> headMultiset(E upperBound, BoundType boundType)
  {
    return getSubMultiset(0, elementSet.headIndex(upperBound, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
  }
  
  public ImmutableSortedMultiset<E> tailMultiset(E lowerBound, BoundType boundType)
  {
    return getSubMultiset(elementSet.tailIndex(lowerBound, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), length);
  }
  
  ImmutableSortedMultiset<E> getSubMultiset(int from, int to)
  {
    Preconditions.checkPositionIndexes(from, to, length);
    if (from == to) {
      return emptyMultiset(comparator());
    }
    if ((from == 0) && (to == length)) {
      return this;
    }
    RegularImmutableSortedSet<E> subElementSet = (RegularImmutableSortedSet)elementSet.getSubSet(from, to);
    
    return new RegularImmutableSortedMultiset(subElementSet, counts, cumulativeCounts, offset + from, to - from);
  }
  
  boolean isPartialView()
  {
    return (offset > 0) || (length < counts.length);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableSortedMultiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
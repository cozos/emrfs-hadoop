package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

final class ImmutableRangeSet$ComplementRanges
  extends ImmutableList<Range<C>>
{
  private final boolean positiveBoundedBelow;
  private final boolean positiveBoundedAbove;
  private final int size;
  
  ImmutableRangeSet$ComplementRanges(ImmutableRangeSet arg1)
  {
    positiveBoundedBelow = ((Range)ImmutableRangeSet.access$000(???).get(0)).hasLowerBound();
    positiveBoundedAbove = ((Range)Iterables.getLast(ImmutableRangeSet.access$000(???))).hasUpperBound();
    
    int size = ImmutableRangeSet.access$000(???).size() - 1;
    if (positiveBoundedBelow) {
      size++;
    }
    if (positiveBoundedAbove) {
      size++;
    }
    this.size = size;
  }
  
  public int size()
  {
    return size;
  }
  
  public Range<C> get(int index)
  {
    Preconditions.checkElementIndex(index, size);
    Cut<C> lowerBound;
    Cut<C> lowerBound;
    if (positiveBoundedBelow) {
      lowerBound = index == 0 ? Cut.belowAll() : access$000this$0).get(index - 1)).upperBound;
    } else {
      lowerBound = access$000this$0).get(index)).upperBound;
    }
    Cut<C> upperBound;
    Cut<C> upperBound;
    if ((positiveBoundedAbove) && (index == size - 1)) {
      upperBound = Cut.aboveAll();
    } else {
      upperBound = access$000this$0).get(index + (positiveBoundedBelow ? 0 : 1))).lowerBound;
    }
    return Range.create(lowerBound, upperBound);
  }
  
  boolean isPartialView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableRangeSet.ComplementRanges
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
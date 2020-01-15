package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

class ImmutableRangeSet$1
  extends ImmutableList<Range<C>>
{
  ImmutableRangeSet$1(ImmutableRangeSet paramImmutableRangeSet, int paramInt1, int paramInt2, Range paramRange) {}
  
  public int size()
  {
    return val$length;
  }
  
  public Range<C> get(int index)
  {
    Preconditions.checkElementIndex(index, val$length);
    if ((index == 0) || (index == val$length - 1)) {
      return ((Range)ImmutableRangeSet.access$000(this$0).get(index + val$fromIndex)).intersection(val$range);
    }
    return (Range)ImmutableRangeSet.access$000(this$0).get(index + val$fromIndex);
  }
  
  boolean isPartialView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableRangeSet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
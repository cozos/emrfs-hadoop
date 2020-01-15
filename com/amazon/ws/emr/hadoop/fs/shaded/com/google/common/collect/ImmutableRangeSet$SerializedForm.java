package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;

final class ImmutableRangeSet$SerializedForm<C extends Comparable>
  implements Serializable
{
  private final ImmutableList<Range<C>> ranges;
  
  ImmutableRangeSet$SerializedForm(ImmutableList<Range<C>> ranges)
  {
    this.ranges = ranges;
  }
  
  Object readResolve()
  {
    if (ranges.isEmpty()) {
      return ImmutableRangeSet.of();
    }
    if (ranges.equals(ImmutableList.of(Range.all()))) {
      return ImmutableRangeSet.all();
    }
    return new ImmutableRangeSet(ranges);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableRangeSet.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
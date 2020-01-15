package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

public class ImmutableRangeSet$Builder<C extends Comparable<?>>
{
  private final RangeSet<C> rangeSet;
  
  public ImmutableRangeSet$Builder()
  {
    rangeSet = TreeRangeSet.create();
  }
  
  public Builder<C> add(Range<C> range)
  {
    if (range.isEmpty())
    {
      String str = String.valueOf(String.valueOf(range));throw new IllegalArgumentException(33 + str.length() + "range must not be empty, but was " + str);
    }
    if (!rangeSet.complement().encloses(range))
    {
      for (Range<C> currentRange : rangeSet.asRanges()) {
        Preconditions.checkArgument((!currentRange.isConnected(range)) || (currentRange.intersection(range).isEmpty()), "Ranges may not overlap, but received %s and %s", new Object[] { currentRange, range });
      }
      throw new AssertionError("should have thrown an IAE above");
    }
    rangeSet.add(range);
    return this;
  }
  
  public Builder<C> addAll(RangeSet<C> ranges)
  {
    for (Range<C> range : ranges.asRanges()) {
      add(range);
    }
    return this;
  }
  
  public ImmutableRangeSet<C> build()
  {
    return ImmutableRangeSet.copyOf(rangeSet);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableRangeSet.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
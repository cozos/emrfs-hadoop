package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class TreeRangeSet$RangesByUpperBound$2
  extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>>
{
  TreeRangeSet$RangesByUpperBound$2(TreeRangeSet.RangesByUpperBound paramRangesByUpperBound, PeekingIterator paramPeekingIterator) {}
  
  protected Map.Entry<Cut<C>, Range<C>> computeNext()
  {
    if (!val$backingItr.hasNext()) {
      return (Map.Entry)endOfData();
    }
    Range<C> range = (Range)val$backingItr.next();
    return access$000this$0).lowerBound.isLessThan(upperBound) ? Maps.immutableEntry(upperBound, range) : (Map.Entry)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeSet.RangesByUpperBound.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
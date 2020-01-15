package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeSet$SubRangeSetRangesByLowerBound$1
  extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>>
{
  TreeRangeSet$SubRangeSetRangesByLowerBound$1(TreeRangeSet.SubRangeSetRangesByLowerBound paramSubRangeSetRangesByLowerBound, Iterator paramIterator, Cut paramCut) {}
  
  protected Map.Entry<Cut<C>, Range<C>> computeNext()
  {
    if (!val$completeRangeItr.hasNext()) {
      return (Map.Entry)endOfData();
    }
    Range<C> nextRange = (Range)val$completeRangeItr.next();
    if (val$upperBoundOnLowerBounds.isLessThan(lowerBound)) {
      return (Map.Entry)endOfData();
    }
    nextRange = nextRange.intersection(TreeRangeSet.SubRangeSetRangesByLowerBound.access$300(this$0));
    return Maps.immutableEntry(lowerBound, nextRange);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
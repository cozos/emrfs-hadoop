package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeSet$SubRangeSetRangesByLowerBound$2
  extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>>
{
  TreeRangeSet$SubRangeSetRangesByLowerBound$2(TreeRangeSet.SubRangeSetRangesByLowerBound paramSubRangeSetRangesByLowerBound, Iterator paramIterator) {}
  
  protected Map.Entry<Cut<C>, Range<C>> computeNext()
  {
    if (!val$completeRangeItr.hasNext()) {
      return (Map.Entry)endOfData();
    }
    Range<C> nextRange = (Range)val$completeRangeItr.next();
    if (access$300this$0).lowerBound.compareTo(upperBound) >= 0) {
      return (Map.Entry)endOfData();
    }
    nextRange = nextRange.intersection(TreeRangeSet.SubRangeSetRangesByLowerBound.access$300(this$0));
    if (TreeRangeSet.SubRangeSetRangesByLowerBound.access$400(this$0).contains(lowerBound)) {
      return Maps.immutableEntry(lowerBound, nextRange);
    }
    return (Map.Entry)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
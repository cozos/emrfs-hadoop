package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeSet$RangesByUpperBound$1
  extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>>
{
  TreeRangeSet$RangesByUpperBound$1(TreeRangeSet.RangesByUpperBound paramRangesByUpperBound, Iterator paramIterator) {}
  
  protected Map.Entry<Cut<C>, Range<C>> computeNext()
  {
    if (!val$backingItr.hasNext()) {
      return (Map.Entry)endOfData();
    }
    Range<C> range = (Range)val$backingItr.next();
    if (access$000this$0).upperBound.isLessThan(upperBound)) {
      return (Map.Entry)endOfData();
    }
    return Maps.immutableEntry(upperBound, range);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeSet.RangesByUpperBound.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class TreeRangeSet$ComplementRangesByLowerBound$1
  extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>>
{
  Cut<C> nextComplementRangeLowerBound = val$firstComplementRangeLowerBound;
  
  TreeRangeSet$ComplementRangesByLowerBound$1(TreeRangeSet.ComplementRangesByLowerBound paramComplementRangesByLowerBound, Cut paramCut, PeekingIterator paramPeekingIterator) {}
  
  protected Map.Entry<Cut<C>, Range<C>> computeNext()
  {
    if ((access$100this$0).upperBound.isLessThan(nextComplementRangeLowerBound)) || (nextComplementRangeLowerBound == Cut.aboveAll())) {
      return (Map.Entry)endOfData();
    }
    Range<C> negativeRange;
    if (val$positiveItr.hasNext())
    {
      Range<C> positiveRange = (Range)val$positiveItr.next();
      Range<C> negativeRange = Range.create(nextComplementRangeLowerBound, lowerBound);
      nextComplementRangeLowerBound = upperBound;
    }
    else
    {
      negativeRange = Range.create(nextComplementRangeLowerBound, Cut.aboveAll());
      nextComplementRangeLowerBound = Cut.aboveAll();
    }
    return Maps.immutableEntry(lowerBound, negativeRange);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
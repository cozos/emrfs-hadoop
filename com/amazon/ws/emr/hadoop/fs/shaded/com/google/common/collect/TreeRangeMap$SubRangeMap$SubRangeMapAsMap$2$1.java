package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2$1
  extends AbstractIterator<Map.Entry<Range<K>, V>>
{
  TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2$1(TreeRangeMap.SubRangeMap.SubRangeMapAsMap.2 param2, Iterator paramIterator) {}
  
  protected Map.Entry<Range<K>, V> computeNext()
  {
    while (val$backingItr.hasNext())
    {
      TreeRangeMap.RangeMapEntry<K, V> entry = (TreeRangeMap.RangeMapEntry)val$backingItr.next();
      if (entry.getLowerBound().compareTo(access$300this$3.this$2.this$1).upperBound) >= 0) {
        break;
      }
      if (entry.getUpperBound().compareTo(access$300this$3.this$2.this$1).lowerBound) > 0) {
        return Maps.immutableEntry(entry.getKey().intersection(TreeRangeMap.SubRangeMap.access$300(this$3.this$2.this$1)), entry.getValue());
      }
    }
    return (Map.Entry)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

class ImmutableRangeMap$1
  extends ImmutableList<Range<K>>
{
  ImmutableRangeMap$1(ImmutableRangeMap paramImmutableRangeMap, int paramInt1, int paramInt2, Range paramRange) {}
  
  public int size()
  {
    return val$len;
  }
  
  public Range<K> get(int index)
  {
    Preconditions.checkElementIndex(index, val$len);
    if ((index == 0) || (index == val$len - 1)) {
      return ((Range)ImmutableRangeMap.access$000(this$0).get(index + val$off)).intersection(val$range);
    }
    return (Range)ImmutableRangeMap.access$000(this$0).get(index + val$off);
  }
  
  boolean isPartialView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableRangeMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
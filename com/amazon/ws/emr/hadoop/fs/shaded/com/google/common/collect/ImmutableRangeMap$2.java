package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class ImmutableRangeMap$2
  extends ImmutableRangeMap<K, V>
{
  ImmutableRangeMap$2(ImmutableRangeMap paramImmutableRangeMap1, ImmutableList x0, ImmutableList x1, Range paramRange, ImmutableRangeMap paramImmutableRangeMap2)
  {
    super(x0, x1);
  }
  
  public ImmutableRangeMap<K, V> subRangeMap(Range<K> subRange)
  {
    if (val$range.isConnected(subRange)) {
      return val$outer.subRangeMap(subRange.intersection(val$range));
    }
    return ImmutableRangeMap.of();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableRangeMap.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
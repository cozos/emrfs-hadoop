package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

final class Range$3
  extends Ordering<Range<?>>
{
  public int compare(Range<?> left, Range<?> right)
  {
    return ComparisonChain.start().compare(lowerBound, lowerBound).compare(upperBound, upperBound).result();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Range.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
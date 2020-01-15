package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.util.Arrays;

class CharMatcher$RangesMatcher
  extends CharMatcher
{
  private final char[] rangeStarts;
  private final char[] rangeEnds;
  
  CharMatcher$RangesMatcher(String description, char[] rangeStarts, char[] rangeEnds)
  {
    super(description);
    this.rangeStarts = rangeStarts;
    this.rangeEnds = rangeEnds;
    Preconditions.checkArgument(rangeStarts.length == rangeEnds.length);
    for (int i = 0; i < rangeStarts.length; i++)
    {
      Preconditions.checkArgument(rangeStarts[i] <= rangeEnds[i]);
      if (i + 1 < rangeStarts.length) {
        Preconditions.checkArgument(rangeEnds[i] < rangeStarts[(i + 1)]);
      }
    }
  }
  
  public boolean matches(char c)
  {
    int index = Arrays.binarySearch(rangeStarts, c);
    if (index >= 0) {
      return true;
    }
    index = (index ^ 0xFFFFFFFF) - 1;
    return (index >= 0) && (c <= rangeEnds[index]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.RangesMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
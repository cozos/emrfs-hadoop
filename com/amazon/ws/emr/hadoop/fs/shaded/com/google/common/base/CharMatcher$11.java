package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.Arrays;
import java.util.BitSet;

final class CharMatcher$11
  extends CharMatcher
{
  CharMatcher$11(String x0, char[] paramArrayOfChar)
  {
    super(x0);
  }
  
  public boolean matches(char c)
  {
    return Arrays.binarySearch(val$chars, c) >= 0;
  }
  
  @GwtIncompatible("java.util.BitSet")
  void setBits(BitSet table)
  {
    for (char c : val$chars) {
      table.set(c);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
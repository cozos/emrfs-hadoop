package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

final class CharMatcher$13
  extends CharMatcher.FastMatcher
{
  CharMatcher$13(String x0, char paramChar1, char paramChar2)
  {
    super(x0);
  }
  
  public boolean matches(char c)
  {
    return (val$startInclusive <= c) && (c <= val$endInclusive);
  }
  
  @GwtIncompatible("java.util.BitSet")
  void setBits(BitSet table)
  {
    table.set(val$startInclusive, val$endInclusive + '\001');
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
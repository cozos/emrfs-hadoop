package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

final class CharMatcher$12
  extends CharMatcher.FastMatcher
{
  CharMatcher$12(String x0, char paramChar1, char paramChar2)
  {
    super(x0);
  }
  
  public boolean matches(char c)
  {
    return (c == val$match1) || (c == val$match2);
  }
  
  @GwtIncompatible("java.util.BitSet")
  void setBits(BitSet table)
  {
    table.set(val$match1);
    table.set(val$match2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
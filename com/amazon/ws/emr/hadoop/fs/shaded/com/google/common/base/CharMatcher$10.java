package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

final class CharMatcher$10
  extends CharMatcher.FastMatcher
{
  CharMatcher$10(String x0, char paramChar)
  {
    super(x0);
  }
  
  public boolean matches(char c)
  {
    return c != val$match;
  }
  
  public CharMatcher and(CharMatcher other)
  {
    return other.matches(val$match) ? super.and(other) : other;
  }
  
  public CharMatcher or(CharMatcher other)
  {
    return other.matches(val$match) ? ANY : this;
  }
  
  @GwtIncompatible("java.util.BitSet")
  void setBits(BitSet table)
  {
    table.set(0, val$match);
    table.set(val$match + '\001', 65536);
  }
  
  public CharMatcher negate()
  {
    return is(val$match);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
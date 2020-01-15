package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

final class CharMatcher$9
  extends CharMatcher.FastMatcher
{
  CharMatcher$9(String x0, char paramChar)
  {
    super(x0);
  }
  
  public boolean matches(char c)
  {
    return c == val$match;
  }
  
  public String replaceFrom(CharSequence sequence, char replacement)
  {
    return sequence.toString().replace(val$match, replacement);
  }
  
  public CharMatcher and(CharMatcher other)
  {
    return other.matches(val$match) ? this : NONE;
  }
  
  public CharMatcher or(CharMatcher other)
  {
    return other.matches(val$match) ? other : super.or(other);
  }
  
  public CharMatcher negate()
  {
    return isNot(val$match);
  }
  
  @GwtIncompatible("java.util.BitSet")
  void setBits(BitSet table)
  {
    table.set(val$match);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
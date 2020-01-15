package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

class CharMatcher$And
  extends CharMatcher
{
  final CharMatcher first;
  final CharMatcher second;
  
  CharMatcher$And(CharMatcher a, CharMatcher b)
  {
    this(a, b, 19 + str1.length() + str2.length() + "CharMatcher.and(" + str1 + ", " + str2 + ")");
  }
  
  CharMatcher$And(CharMatcher a, CharMatcher b, String description)
  {
    super(description);
    first = ((CharMatcher)Preconditions.checkNotNull(a));
    second = ((CharMatcher)Preconditions.checkNotNull(b));
  }
  
  public boolean matches(char c)
  {
    return (first.matches(c)) && (second.matches(c));
  }
  
  @GwtIncompatible("java.util.BitSet")
  void setBits(BitSet table)
  {
    BitSet tmp1 = new BitSet();
    first.setBits(tmp1);
    BitSet tmp2 = new BitSet();
    second.setBits(tmp2);
    tmp1.and(tmp2);
    table.or(tmp1);
  }
  
  CharMatcher withToString(String description)
  {
    return new And(first, second, description);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.And
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
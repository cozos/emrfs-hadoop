package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

class CharMatcher$Or
  extends CharMatcher
{
  final CharMatcher first;
  final CharMatcher second;
  
  CharMatcher$Or(CharMatcher a, CharMatcher b, String description)
  {
    super(description);
    first = ((CharMatcher)Preconditions.checkNotNull(a));
    second = ((CharMatcher)Preconditions.checkNotNull(b));
  }
  
  CharMatcher$Or(CharMatcher a, CharMatcher b)
  {
    this(a, b, 18 + str1.length() + str2.length() + "CharMatcher.or(" + str1 + ", " + str2 + ")");
  }
  
  @GwtIncompatible("java.util.BitSet")
  void setBits(BitSet table)
  {
    first.setBits(table);
    second.setBits(table);
  }
  
  public boolean matches(char c)
  {
    return (first.matches(c)) || (second.matches(c));
  }
  
  CharMatcher withToString(String description)
  {
    return new Or(first, second, description);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.Or
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
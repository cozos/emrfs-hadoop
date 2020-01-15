package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

class CharMatcher$NegatedMatcher
  extends CharMatcher
{
  final CharMatcher original;
  
  CharMatcher$NegatedMatcher(String toString, CharMatcher original)
  {
    super(toString);
    this.original = original;
  }
  
  CharMatcher$NegatedMatcher(CharMatcher original)
  {
    this(9 + str.length() + str + ".negate()", original);
  }
  
  public boolean matches(char c)
  {
    return !original.matches(c);
  }
  
  public boolean matchesAllOf(CharSequence sequence)
  {
    return original.matchesNoneOf(sequence);
  }
  
  public boolean matchesNoneOf(CharSequence sequence)
  {
    return original.matchesAllOf(sequence);
  }
  
  public int countIn(CharSequence sequence)
  {
    return sequence.length() - original.countIn(sequence);
  }
  
  @GwtIncompatible("java.util.BitSet")
  void setBits(BitSet table)
  {
    BitSet tmp = new BitSet();
    original.setBits(tmp);
    tmp.flip(0, 65536);
    table.or(tmp);
  }
  
  public CharMatcher negate()
  {
    return original;
  }
  
  CharMatcher withToString(String description)
  {
    return new NegatedMatcher(description, original);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.NegatedMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
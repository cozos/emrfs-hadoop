package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

final class CharMatcher$NegatedFastMatcher
  extends CharMatcher.NegatedMatcher
{
  CharMatcher$NegatedFastMatcher(CharMatcher original)
  {
    super(original);
  }
  
  CharMatcher$NegatedFastMatcher(String toString, CharMatcher original)
  {
    super(toString, original);
  }
  
  public final CharMatcher precomputed()
  {
    return this;
  }
  
  CharMatcher withToString(String description)
  {
    return new NegatedFastMatcher(description, original);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.NegatedFastMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
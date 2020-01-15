package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

abstract class CharMatcher$FastMatcher
  extends CharMatcher
{
  CharMatcher$FastMatcher() {}
  
  CharMatcher$FastMatcher(String description)
  {
    super(description);
  }
  
  public final CharMatcher precomputed()
  {
    return this;
  }
  
  public CharMatcher negate()
  {
    return new CharMatcher.NegatedFastMatcher(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.FastMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
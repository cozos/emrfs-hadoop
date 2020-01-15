package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

final class CharMatcher$14
  extends CharMatcher
{
  CharMatcher$14(String x0, Predicate paramPredicate)
  {
    super(x0);
  }
  
  public boolean matches(char c)
  {
    return val$predicate.apply(Character.valueOf(c));
  }
  
  public boolean apply(Character character)
  {
    return val$predicate.apply(Preconditions.checkNotNull(character));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
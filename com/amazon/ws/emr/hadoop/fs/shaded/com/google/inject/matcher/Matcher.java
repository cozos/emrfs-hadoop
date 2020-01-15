package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

public abstract interface Matcher<T>
{
  public abstract boolean matches(T paramT);
  
  public abstract Matcher<T> and(Matcher<? super T> paramMatcher);
  
  public abstract Matcher<T> or(Matcher<? super T> paramMatcher);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
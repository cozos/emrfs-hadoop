package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

import java.io.Serializable;

class AbstractMatcher$AndMatcher<T>
  extends AbstractMatcher<T>
  implements Serializable
{
  private final Matcher<? super T> a;
  private final Matcher<? super T> b;
  private static final long serialVersionUID = 0L;
  
  public AbstractMatcher$AndMatcher(Matcher<? super T> a, Matcher<? super T> b)
  {
    this.a = a;
    this.b = b;
  }
  
  public boolean matches(T t)
  {
    return (a.matches(t)) && (b.matches(t));
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof AndMatcher)) && (a.equals(a)) && (b.equals(b));
  }
  
  public int hashCode()
  {
    return 41 * (a.hashCode() ^ b.hashCode());
  }
  
  public String toString()
  {
    return "and(" + a + ", " + b + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.AbstractMatcher.AndMatcher
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
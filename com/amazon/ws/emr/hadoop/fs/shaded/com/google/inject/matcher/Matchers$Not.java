package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.io.Serializable;

class Matchers$Not<T>
  extends AbstractMatcher<T>
  implements Serializable
{
  final Matcher<? super T> delegate;
  private static final long serialVersionUID = 0L;
  
  private Matchers$Not(Matcher<? super T> delegate)
  {
    this.delegate = ((Matcher).Preconditions.checkNotNull(delegate, "delegate"));
  }
  
  public boolean matches(T t)
  {
    return !delegate.matches(t);
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof Not)) && (delegate.equals(delegate));
  }
  
  public int hashCode()
  {
    return -delegate.hashCode();
  }
  
  public String toString()
  {
    return "not(" + delegate + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers.Not
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
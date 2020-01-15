package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.io.Serializable;

class Matchers$Only
  extends AbstractMatcher<Object>
  implements Serializable
{
  private final Object value;
  private static final long serialVersionUID = 0L;
  
  public Matchers$Only(Object value)
  {
    this.value = .Preconditions.checkNotNull(value, "value");
  }
  
  public boolean matches(Object other)
  {
    return value.equals(other);
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof Only)) && (value.equals(value));
  }
  
  public int hashCode()
  {
    return 37 * value.hashCode();
  }
  
  public String toString()
  {
    return "only(" + value + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers.Only
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
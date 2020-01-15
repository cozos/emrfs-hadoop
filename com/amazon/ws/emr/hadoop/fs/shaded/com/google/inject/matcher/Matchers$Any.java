package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

import java.io.Serializable;

class Matchers$Any
  extends AbstractMatcher<Object>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  
  public boolean matches(Object o)
  {
    return true;
  }
  
  public String toString()
  {
    return "any()";
  }
  
  public Object readResolve()
  {
    return Matchers.any();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers.Any
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
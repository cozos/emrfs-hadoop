package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.io.Serializable;
import java.lang.reflect.Method;

class Matchers$Returns
  extends AbstractMatcher<Method>
  implements Serializable
{
  private final Matcher<? super Class<?>> returnType;
  private static final long serialVersionUID = 0L;
  
  public Matchers$Returns(Matcher<? super Class<?>> returnType)
  {
    this.returnType = ((Matcher).Preconditions.checkNotNull(returnType, "return type matcher"));
  }
  
  public boolean matches(Method m)
  {
    return returnType.matches(m.getReturnType());
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof Returns)) && (returnType.equals(returnType));
  }
  
  public int hashCode()
  {
    return 37 * returnType.hashCode();
  }
  
  public String toString()
  {
    return "returns(" + returnType + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers.Returns
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
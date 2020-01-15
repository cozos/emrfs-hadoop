package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.io.Serializable;

class Matchers$SubclassesOf
  extends AbstractMatcher<Class>
  implements Serializable
{
  private final Class<?> superclass;
  private static final long serialVersionUID = 0L;
  
  public Matchers$SubclassesOf(Class<?> superclass)
  {
    this.superclass = ((Class).Preconditions.checkNotNull(superclass, "superclass"));
  }
  
  public boolean matches(Class subclass)
  {
    return superclass.isAssignableFrom(subclass);
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof SubclassesOf)) && (superclass.equals(superclass));
  }
  
  public int hashCode()
  {
    return 37 * superclass.hashCode();
  }
  
  public String toString()
  {
    return "subclassesOf(" + superclass.getSimpleName() + ".class)";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers.SubclassesOf
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
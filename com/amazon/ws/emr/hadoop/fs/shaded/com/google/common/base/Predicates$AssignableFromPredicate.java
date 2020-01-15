package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtIncompatible("Class.isAssignableFrom")
class Predicates$AssignableFromPredicate
  implements Predicate<Class<?>>, Serializable
{
  private final Class<?> clazz;
  private static final long serialVersionUID = 0L;
  
  private Predicates$AssignableFromPredicate(Class<?> clazz)
  {
    this.clazz = ((Class)Preconditions.checkNotNull(clazz));
  }
  
  public boolean apply(Class<?> input)
  {
    return clazz.isAssignableFrom(input);
  }
  
  public int hashCode()
  {
    return clazz.hashCode();
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof AssignableFromPredicate))
    {
      AssignableFromPredicate that = (AssignableFromPredicate)obj;
      return clazz == clazz;
    }
    return false;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(clazz.getName()));return 27 + str.length() + "Predicates.assignableFrom(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.AssignableFromPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
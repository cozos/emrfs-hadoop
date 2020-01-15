package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtIncompatible("Class.isInstance")
class Predicates$InstanceOfPredicate
  implements Predicate<Object>, Serializable
{
  private final Class<?> clazz;
  private static final long serialVersionUID = 0L;
  
  private Predicates$InstanceOfPredicate(Class<?> clazz)
  {
    this.clazz = ((Class)Preconditions.checkNotNull(clazz));
  }
  
  public boolean apply(@Nullable Object o)
  {
    return clazz.isInstance(o);
  }
  
  public int hashCode()
  {
    return clazz.hashCode();
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof InstanceOfPredicate))
    {
      InstanceOfPredicate that = (InstanceOfPredicate)obj;
      return clazz == clazz;
    }
    return false;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(clazz.getName()));return 23 + str.length() + "Predicates.instanceOf(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.InstanceOfPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
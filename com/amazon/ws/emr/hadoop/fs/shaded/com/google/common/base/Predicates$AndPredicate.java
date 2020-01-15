package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

class Predicates$AndPredicate<T>
  implements Predicate<T>, Serializable
{
  private final List<? extends Predicate<? super T>> components;
  private static final long serialVersionUID = 0L;
  
  private Predicates$AndPredicate(List<? extends Predicate<? super T>> components)
  {
    this.components = components;
  }
  
  public boolean apply(@Nullable T t)
  {
    for (int i = 0; i < components.size(); i++) {
      if (!((Predicate)components.get(i)).apply(t)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    return components.hashCode() + 306654252;
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof AndPredicate))
    {
      AndPredicate<?> that = (AndPredicate)obj;
      return components.equals(components);
    }
    return false;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(Predicates.access$800().join(components)));return 16 + str.length() + "Predicates.and(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.AndPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
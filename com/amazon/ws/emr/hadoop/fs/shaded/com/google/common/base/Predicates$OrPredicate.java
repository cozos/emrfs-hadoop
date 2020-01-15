package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

class Predicates$OrPredicate<T>
  implements Predicate<T>, Serializable
{
  private final List<? extends Predicate<? super T>> components;
  private static final long serialVersionUID = 0L;
  
  private Predicates$OrPredicate(List<? extends Predicate<? super T>> components)
  {
    this.components = components;
  }
  
  public boolean apply(@Nullable T t)
  {
    for (int i = 0; i < components.size(); i++) {
      if (((Predicate)components.get(i)).apply(t)) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return components.hashCode() + 87855567;
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof OrPredicate))
    {
      OrPredicate<?> that = (OrPredicate)obj;
      return components.equals(components);
    }
    return false;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(Predicates.access$800().join(components)));return 15 + str.length() + "Predicates.or(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.OrPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
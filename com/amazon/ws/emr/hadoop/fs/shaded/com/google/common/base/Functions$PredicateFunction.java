package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$PredicateFunction<T>
  implements Function<T, Boolean>, Serializable
{
  private final Predicate<T> predicate;
  private static final long serialVersionUID = 0L;
  
  private Functions$PredicateFunction(Predicate<T> predicate)
  {
    this.predicate = ((Predicate)Preconditions.checkNotNull(predicate));
  }
  
  public Boolean apply(@Nullable T t)
  {
    return Boolean.valueOf(predicate.apply(t));
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof PredicateFunction))
    {
      PredicateFunction<?> that = (PredicateFunction)obj;
      return predicate.equals(predicate);
    }
    return false;
  }
  
  public int hashCode()
  {
    return predicate.hashCode();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(predicate));return 14 + str.length() + "forPredicate(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Functions.PredicateFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
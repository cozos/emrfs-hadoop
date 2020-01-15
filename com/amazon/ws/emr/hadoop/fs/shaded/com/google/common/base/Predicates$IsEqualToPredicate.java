package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$IsEqualToPredicate<T>
  implements Predicate<T>, Serializable
{
  private final T target;
  private static final long serialVersionUID = 0L;
  
  private Predicates$IsEqualToPredicate(T target)
  {
    this.target = target;
  }
  
  public boolean apply(T t)
  {
    return target.equals(t);
  }
  
  public int hashCode()
  {
    return target.hashCode();
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof IsEqualToPredicate))
    {
      IsEqualToPredicate<?> that = (IsEqualToPredicate)obj;
      return target.equals(target);
    }
    return false;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(target));return 20 + str.length() + "Predicates.equalTo(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.IsEqualToPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

class Predicates$InPredicate<T>
  implements Predicate<T>, Serializable
{
  private final Collection<?> target;
  private static final long serialVersionUID = 0L;
  
  private Predicates$InPredicate(Collection<?> target)
  {
    this.target = ((Collection)Preconditions.checkNotNull(target));
  }
  
  public boolean apply(@Nullable T t)
  {
    try
    {
      return target.contains(t);
    }
    catch (NullPointerException e)
    {
      return false;
    }
    catch (ClassCastException e) {}
    return false;
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof InPredicate))
    {
      InPredicate<?> that = (InPredicate)obj;
      return target.equals(target);
    }
    return false;
  }
  
  public int hashCode()
  {
    return target.hashCode();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(target));return 15 + str.length() + "Predicates.in(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.InPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
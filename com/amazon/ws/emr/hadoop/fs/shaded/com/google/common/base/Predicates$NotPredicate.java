package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$NotPredicate<T>
  implements Predicate<T>, Serializable
{
  final Predicate<T> predicate;
  private static final long serialVersionUID = 0L;
  
  Predicates$NotPredicate(Predicate<T> predicate)
  {
    this.predicate = ((Predicate)Preconditions.checkNotNull(predicate));
  }
  
  public boolean apply(@Nullable T t)
  {
    return !predicate.apply(t);
  }
  
  public int hashCode()
  {
    return predicate.hashCode() ^ 0xFFFFFFFF;
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof NotPredicate))
    {
      NotPredicate<?> that = (NotPredicate)obj;
      return predicate.equals(predicate);
    }
    return false;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(predicate.toString()));return 16 + str.length() + "Predicates.not(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates.NotPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
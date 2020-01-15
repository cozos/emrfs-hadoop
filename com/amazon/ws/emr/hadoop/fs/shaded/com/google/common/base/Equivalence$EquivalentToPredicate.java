package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

final class Equivalence$EquivalentToPredicate<T>
  implements Predicate<T>, Serializable
{
  private final Equivalence<T> equivalence;
  @Nullable
  private final T target;
  private static final long serialVersionUID = 0L;
  
  Equivalence$EquivalentToPredicate(Equivalence<T> equivalence, @Nullable T target)
  {
    this.equivalence = ((Equivalence)Preconditions.checkNotNull(equivalence));
    this.target = target;
  }
  
  public boolean apply(@Nullable T input)
  {
    return equivalence.equivalent(input, target);
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj instanceof EquivalentToPredicate))
    {
      EquivalentToPredicate<?> that = (EquivalentToPredicate)obj;
      return (equivalence.equals(equivalence)) && (Objects.equal(target, target));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { equivalence, target });
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(equivalence));String str2 = String.valueOf(String.valueOf(target));return 15 + str1.length() + str2.length() + str1 + ".equivalentTo(" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence.EquivalentToPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
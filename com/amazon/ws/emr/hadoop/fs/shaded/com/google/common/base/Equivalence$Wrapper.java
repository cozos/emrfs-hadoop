package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

public final class Equivalence$Wrapper<T>
  implements Serializable
{
  private final Equivalence<? super T> equivalence;
  @Nullable
  private final T reference;
  private static final long serialVersionUID = 0L;
  
  private Equivalence$Wrapper(Equivalence<? super T> equivalence, @Nullable T reference)
  {
    this.equivalence = ((Equivalence)Preconditions.checkNotNull(equivalence));
    this.reference = reference;
  }
  
  @Nullable
  public T get()
  {
    return (T)reference;
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if (obj == this) {
      return true;
    }
    if ((obj instanceof Wrapper))
    {
      Wrapper<?> that = (Wrapper)obj;
      if (this.equivalence.equals(equivalence))
      {
        Equivalence<Object> equivalence = this.equivalence;
        return equivalence.equivalent(reference, reference);
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return equivalence.hash(reference);
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(equivalence));String str2 = String.valueOf(String.valueOf(reference));return 7 + str1.length() + str2.length() + str1 + ".wrap(" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence.Wrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
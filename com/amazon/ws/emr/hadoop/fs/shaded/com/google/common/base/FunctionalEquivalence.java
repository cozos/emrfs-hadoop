package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
final class FunctionalEquivalence<F, T>
  extends Equivalence<F>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final Function<F, ? extends T> function;
  private final Equivalence<T> resultEquivalence;
  
  FunctionalEquivalence(Function<F, ? extends T> function, Equivalence<T> resultEquivalence)
  {
    this.function = ((Function)Preconditions.checkNotNull(function));
    this.resultEquivalence = ((Equivalence)Preconditions.checkNotNull(resultEquivalence));
  }
  
  protected boolean doEquivalent(F a, F b)
  {
    return resultEquivalence.equivalent(function.apply(a), function.apply(b));
  }
  
  protected int doHash(F a)
  {
    return resultEquivalence.hash(function.apply(a));
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if (obj == this) {
      return true;
    }
    if ((obj instanceof FunctionalEquivalence))
    {
      FunctionalEquivalence<?, ?> that = (FunctionalEquivalence)obj;
      return (function.equals(function)) && (resultEquivalence.equals(resultEquivalence));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { function, resultEquivalence });
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(resultEquivalence));String str2 = String.valueOf(String.valueOf(function));return 13 + str1.length() + str2.length() + str1 + ".onResultOf(" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.FunctionalEquivalence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
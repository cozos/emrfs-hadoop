package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class ByFunctionOrdering<F, T>
  extends Ordering<F>
  implements Serializable
{
  final Function<F, ? extends T> function;
  final Ordering<T> ordering;
  private static final long serialVersionUID = 0L;
  
  ByFunctionOrdering(Function<F, ? extends T> function, Ordering<T> ordering)
  {
    this.function = ((Function)Preconditions.checkNotNull(function));
    this.ordering = ((Ordering)Preconditions.checkNotNull(ordering));
  }
  
  public int compare(F left, F right)
  {
    return ordering.compare(function.apply(left), function.apply(right));
  }
  
  public boolean equals(@Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof ByFunctionOrdering))
    {
      ByFunctionOrdering<?, ?> that = (ByFunctionOrdering)object;
      return (function.equals(function)) && (ordering.equals(ordering));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { function, ordering });
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(ordering));String str2 = String.valueOf(String.valueOf(function));return 13 + str1.length() + str2.length() + str1 + ".onResultOf(" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ByFunctionOrdering
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
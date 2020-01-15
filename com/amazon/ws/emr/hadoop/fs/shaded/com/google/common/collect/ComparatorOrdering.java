package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class ComparatorOrdering<T>
  extends Ordering<T>
  implements Serializable
{
  final Comparator<T> comparator;
  private static final long serialVersionUID = 0L;
  
  ComparatorOrdering(Comparator<T> comparator)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(comparator));
  }
  
  public int compare(T a, T b)
  {
    return comparator.compare(a, b);
  }
  
  public boolean equals(@Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof ComparatorOrdering))
    {
      ComparatorOrdering<?> that = (ComparatorOrdering)object;
      return comparator.equals(comparator);
    }
    return false;
  }
  
  public int hashCode()
  {
    return comparator.hashCode();
  }
  
  public String toString()
  {
    return comparator.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ComparatorOrdering
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
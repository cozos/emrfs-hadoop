package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;

@GwtCompatible(serializable=true)
final class CompoundOrdering<T>
  extends Ordering<T>
  implements Serializable
{
  final ImmutableList<Comparator<? super T>> comparators;
  private static final long serialVersionUID = 0L;
  
  CompoundOrdering(Comparator<? super T> primary, Comparator<? super T> secondary)
  {
    comparators = ImmutableList.of(primary, secondary);
  }
  
  CompoundOrdering(Iterable<? extends Comparator<? super T>> comparators)
  {
    this.comparators = ImmutableList.copyOf(comparators);
  }
  
  public int compare(T left, T right)
  {
    int size = comparators.size();
    for (int i = 0; i < size; i++)
    {
      int result = ((Comparator)comparators.get(i)).compare(left, right);
      if (result != 0) {
        return result;
      }
    }
    return 0;
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof CompoundOrdering))
    {
      CompoundOrdering<?> that = (CompoundOrdering)object;
      return comparators.equals(comparators);
    }
    return false;
  }
  
  public int hashCode()
  {
    return comparators.hashCode();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(comparators));return 19 + str.length() + "Ordering.compound(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.CompoundOrdering
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
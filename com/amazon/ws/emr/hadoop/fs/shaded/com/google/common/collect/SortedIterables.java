package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
final class SortedIterables
{
  public static boolean hasSameComparator(Comparator<?> comparator, Iterable<?> elements)
  {
    Preconditions.checkNotNull(comparator);
    Preconditions.checkNotNull(elements);
    Comparator<?> comparator2;
    if ((elements instanceof SortedSet))
    {
      comparator2 = comparator((SortedSet)elements);
    }
    else
    {
      Comparator<?> comparator2;
      if ((elements instanceof SortedIterable)) {
        comparator2 = ((SortedIterable)elements).comparator();
      } else {
        return false;
      }
    }
    Comparator<?> comparator2;
    return comparator.equals(comparator2);
  }
  
  public static <E> Comparator<? super E> comparator(SortedSet<E> sortedSet)
  {
    Comparator<? super E> result = sortedSet.comparator();
    if (result == null) {
      result = Ordering.natural();
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SortedIterables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.LongMath;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

final class Collections2$OrderedPermutationCollection<E>
  extends AbstractCollection<List<E>>
{
  final ImmutableList<E> inputList;
  final Comparator<? super E> comparator;
  final int size;
  
  Collections2$OrderedPermutationCollection(Iterable<E> input, Comparator<? super E> comparator)
  {
    inputList = Ordering.from(comparator).immutableSortedCopy(input);
    this.comparator = comparator;
    size = calculateSize(inputList, comparator);
  }
  
  private static <E> int calculateSize(List<E> sortedInputList, Comparator<? super E> comparator)
  {
    long permutations = 1L;
    int n = 1;
    int r = 1;
    while (n < sortedInputList.size())
    {
      int comparison = comparator.compare(sortedInputList.get(n - 1), sortedInputList.get(n));
      if (comparison < 0)
      {
        permutations *= LongMath.binomial(n, r);
        r = 0;
        if (!Collections2.access$000(permutations)) {
          return Integer.MAX_VALUE;
        }
      }
      n++;
      r++;
    }
    permutations *= LongMath.binomial(n, r);
    if (!Collections2.access$000(permutations)) {
      return Integer.MAX_VALUE;
    }
    return (int)permutations;
  }
  
  public int size()
  {
    return size;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public Iterator<List<E>> iterator()
  {
    return new Collections2.OrderedPermutationIterator(inputList, comparator);
  }
  
  public boolean contains(@Nullable Object obj)
  {
    if ((obj instanceof List))
    {
      List<?> list = (List)obj;
      return Collections2.access$100(inputList, list);
    }
    return false;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(inputList));return 30 + str.length() + "orderedPermutationCollection(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Collections2.OrderedPermutationCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
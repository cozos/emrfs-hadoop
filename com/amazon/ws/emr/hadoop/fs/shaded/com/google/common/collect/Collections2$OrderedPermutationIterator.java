package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class Collections2$OrderedPermutationIterator<E>
  extends AbstractIterator<List<E>>
{
  List<E> nextPermutation;
  final Comparator<? super E> comparator;
  
  Collections2$OrderedPermutationIterator(List<E> list, Comparator<? super E> comparator)
  {
    nextPermutation = Lists.newArrayList(list);
    this.comparator = comparator;
  }
  
  protected List<E> computeNext()
  {
    if (nextPermutation == null) {
      return (List)endOfData();
    }
    ImmutableList<E> next = ImmutableList.copyOf(nextPermutation);
    calculateNextPermutation();
    return next;
  }
  
  void calculateNextPermutation()
  {
    int j = findNextJ();
    if (j == -1)
    {
      nextPermutation = null;
      return;
    }
    int l = findNextL(j);
    Collections.swap(nextPermutation, j, l);
    int n = nextPermutation.size();
    Collections.reverse(nextPermutation.subList(j + 1, n));
  }
  
  int findNextJ()
  {
    for (int k = nextPermutation.size() - 2; k >= 0; k--) {
      if (comparator.compare(nextPermutation.get(k), nextPermutation.get(k + 1)) < 0) {
        return k;
      }
    }
    return -1;
  }
  
  int findNextL(int j)
  {
    E ak = nextPermutation.get(j);
    for (int l = nextPermutation.size() - 1; l > j; l--) {
      if (comparator.compare(ak, nextPermutation.get(l)) < 0) {
        return l;
      }
    }
    throw new AssertionError("this statement should be unreachable");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Collections2.OrderedPermutationIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
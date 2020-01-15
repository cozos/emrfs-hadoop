package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Collections2$PermutationIterator<E>
  extends AbstractIterator<List<E>>
{
  final List<E> list;
  final int[] c;
  final int[] o;
  int j;
  
  Collections2$PermutationIterator(List<E> list)
  {
    this.list = new ArrayList(list);
    int n = list.size();
    c = new int[n];
    o = new int[n];
    Arrays.fill(c, 0);
    Arrays.fill(o, 1);
    j = Integer.MAX_VALUE;
  }
  
  protected List<E> computeNext()
  {
    if (j <= 0) {
      return (List)endOfData();
    }
    ImmutableList<E> next = ImmutableList.copyOf(list);
    calculateNextPermutation();
    return next;
  }
  
  void calculateNextPermutation()
  {
    j = (list.size() - 1);
    int s = 0;
    if (j == -1) {
      return;
    }
    int q;
    for (;;)
    {
      q = c[j] + o[j];
      if (q < 0)
      {
        switchDirection();
      }
      else
      {
        if (q != j + 1) {
          break;
        }
        if (j == 0) {
          return;
        }
        s++;
        switchDirection();
      }
    }
    Collections.swap(list, j - c[j] + s, j - q + s);
    c[j] = q;
  }
  
  void switchDirection()
  {
    o[j] = (-o[j]);
    j -= 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Collections2.PermutationIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$KeyPresentBehavior$3
{
  SortedLists$KeyPresentBehavior$3()
  {
    super(paramString, paramInt, null);
  }
  
  <E> int resultIndex(Comparator<? super E> comparator, E key, List<? extends E> list, int foundIndex)
  {
    int lower = 0;
    int upper = foundIndex;
    while (lower < upper)
    {
      int middle = lower + upper >>> 1;
      int c = comparator.compare(list.get(middle), key);
      if (c < 0) {
        lower = middle + 1;
      } else {
        upper = middle;
      }
    }
    return lower;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SortedLists.KeyPresentBehavior.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
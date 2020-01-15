package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$KeyPresentBehavior$2
{
  SortedLists$KeyPresentBehavior$2()
  {
    super(paramString, paramInt, null);
  }
  
  <E> int resultIndex(Comparator<? super E> comparator, E key, List<? extends E> list, int foundIndex)
  {
    int lower = foundIndex;
    int upper = list.size() - 1;
    while (lower < upper)
    {
      int middle = lower + upper + 1 >>> 1;
      int c = comparator.compare(list.get(middle), key);
      if (c > 0) {
        upper = middle - 1;
      } else {
        lower = middle;
      }
    }
    return lower;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SortedLists.KeyPresentBehavior.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$KeyPresentBehavior$4
{
  SortedLists$KeyPresentBehavior$4()
  {
    super(paramString, paramInt, null);
  }
  
  public <E> int resultIndex(Comparator<? super E> comparator, E key, List<? extends E> list, int foundIndex)
  {
    return LAST_PRESENT.resultIndex(comparator, key, list, foundIndex) + 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SortedLists.KeyPresentBehavior.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
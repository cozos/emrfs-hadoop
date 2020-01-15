package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$KeyPresentBehavior$1
{
  SortedLists$KeyPresentBehavior$1()
  {
    super(paramString, paramInt, null);
  }
  
  <E> int resultIndex(Comparator<? super E> comparator, E key, List<? extends E> list, int foundIndex)
  {
    return foundIndex;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SortedLists.KeyPresentBehavior.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
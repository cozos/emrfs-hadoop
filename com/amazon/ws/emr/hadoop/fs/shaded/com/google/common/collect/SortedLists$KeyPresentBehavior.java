package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.List;

public enum SortedLists$KeyPresentBehavior
{
  ANY_PRESENT,  LAST_PRESENT,  FIRST_PRESENT,  FIRST_AFTER,  LAST_BEFORE;
  
  private SortedLists$KeyPresentBehavior() {}
  
  abstract <E> int resultIndex(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SortedLists.KeyPresentBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
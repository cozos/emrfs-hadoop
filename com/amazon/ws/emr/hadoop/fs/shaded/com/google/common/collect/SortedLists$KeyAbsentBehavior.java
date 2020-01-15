package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

public enum SortedLists$KeyAbsentBehavior
{
  NEXT_LOWER,  NEXT_HIGHER,  INVERTED_INSERTION_INDEX;
  
  private SortedLists$KeyAbsentBehavior() {}
  
  abstract int resultIndex(int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SortedLists.KeyAbsentBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
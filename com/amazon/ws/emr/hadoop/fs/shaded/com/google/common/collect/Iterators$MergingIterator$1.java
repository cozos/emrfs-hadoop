package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;

class Iterators$MergingIterator$1
  implements Comparator<PeekingIterator<T>>
{
  Iterators$MergingIterator$1(Iterators.MergingIterator paramMergingIterator, Comparator paramComparator) {}
  
  public int compare(PeekingIterator<T> o1, PeekingIterator<T> o2)
  {
    return val$itemComparator.compare(o1.peek(), o2.peek());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.MergingIterator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
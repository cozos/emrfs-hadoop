package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

class AbstractSortedMultiset$1
  extends DescendingMultiset<E>
{
  AbstractSortedMultiset$1(AbstractSortedMultiset paramAbstractSortedMultiset) {}
  
  SortedMultiset<E> forwardMultiset()
  {
    return this$0;
  }
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    return this$0.descendingEntryIterator();
  }
  
  public Iterator<E> iterator()
  {
    return this$0.descendingIterator();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractSortedMultiset.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

class Iterators$MergingIterator<T>
  extends UnmodifiableIterator<T>
{
  final Queue<PeekingIterator<T>> queue;
  
  public Iterators$MergingIterator(Iterable<? extends Iterator<? extends T>> iterators, final Comparator<? super T> itemComparator)
  {
    Comparator<PeekingIterator<T>> heapComparator = new Comparator()
    {
      public int compare(PeekingIterator<T> o1, PeekingIterator<T> o2)
      {
        return itemComparator.compare(o1.peek(), o2.peek());
      }
    };
    queue = new PriorityQueue(2, heapComparator);
    for (Iterator<? extends T> iterator : iterators) {
      if (iterator.hasNext()) {
        queue.add(Iterators.peekingIterator(iterator));
      }
    }
  }
  
  public boolean hasNext()
  {
    return !queue.isEmpty();
  }
  
  public T next()
  {
    PeekingIterator<T> nextIter = (PeekingIterator)queue.remove();
    T next = nextIter.next();
    if (nextIter.hasNext()) {
      queue.add(nextIter);
    }
    return next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.MergingIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
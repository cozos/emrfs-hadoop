package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.NoSuchElementException;
import java.util.Queue;

class Iterables$ConsumingQueueIterator<T>
  extends AbstractIterator<T>
{
  private final Queue<T> queue;
  
  private Iterables$ConsumingQueueIterator(Queue<T> queue)
  {
    this.queue = queue;
  }
  
  public T computeNext()
  {
    try
    {
      return (T)queue.remove();
    }
    catch (NoSuchElementException e) {}
    return (T)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.ConsumingQueueIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
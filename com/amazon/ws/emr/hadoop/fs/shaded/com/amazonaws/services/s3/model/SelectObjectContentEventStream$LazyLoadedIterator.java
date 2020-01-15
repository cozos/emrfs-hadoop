package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

abstract class SelectObjectContentEventStream$LazyLoadedIterator<T>
  implements Iterator<T>
{
  private final Queue<T> next = new ArrayDeque();
  private boolean isDone = false;
  
  private SelectObjectContentEventStream$LazyLoadedIterator(SelectObjectContentEventStream paramSelectObjectContentEventStream) {}
  
  public boolean hasNext()
  {
    advanceIfNeeded();
    return !isDone;
  }
  
  public T next()
  {
    advanceIfNeeded();
    if (isDone) {
      throw new NoSuchElementException();
    }
    return (T)next.poll();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  private void advanceIfNeeded()
  {
    if ((!isDone) && (next.isEmpty())) {
      try
      {
        next.addAll(getNext());
        isDone = next.isEmpty();
      }
      catch (IOException e)
      {
        throw new SelectObjectContentEventException("Failed to read S3 select event.", e);
      }
    }
  }
  
  protected abstract Collection<? extends T> getNext()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventStream.LazyLoadedIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
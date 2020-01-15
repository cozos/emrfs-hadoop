package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class $AbstractIterator<T>
  implements Iterator<T>
{
  private State state;
  private T next;
  
  public $AbstractIterator()
  {
    state = State.NOT_READY;
  }
  
  protected abstract T computeNext();
  
  private static enum State
  {
    READY,  NOT_READY,  DONE,  FAILED;
    
    private State() {}
  }
  
  protected final T endOfData()
  {
    state = State.DONE;
    return null;
  }
  
  public boolean hasNext()
  {
    .Preconditions.checkState(state != State.FAILED);
    switch (state)
    {
    case DONE: 
      return false;
    case READY: 
      return true;
    }
    return tryToComputeNext();
  }
  
  private boolean tryToComputeNext()
  {
    state = State.FAILED;
    next = computeNext();
    if (state != State.DONE)
    {
      state = State.READY;
      return true;
    }
    return false;
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    state = State.NOT_READY;
    return (T)next;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..AbstractIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
public abstract class AbstractIterator<T>
  extends UnmodifiableIterator<T>
{
  private State state = State.NOT_READY;
  private T next;
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
  
  public final boolean hasNext()
  {
    Preconditions.checkState(state != State.FAILED);
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
  
  public final T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    state = State.NOT_READY;
    T result = next;
    next = null;
    return result;
  }
  
  public final T peek()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return (T)next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
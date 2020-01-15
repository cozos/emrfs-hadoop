package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class AbstractSequentialIterator<T>
  extends UnmodifiableIterator<T>
{
  private T nextOrNull;
  
  protected AbstractSequentialIterator(@Nullable T firstOrNull)
  {
    nextOrNull = firstOrNull;
  }
  
  protected abstract T computeNext(T paramT);
  
  public final boolean hasNext()
  {
    return nextOrNull != null;
  }
  
  public final T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    try
    {
      return (T)nextOrNull;
    }
    finally
    {
      nextOrNull = computeNext(nextOrNull);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractSequentialIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
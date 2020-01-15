package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.NoSuchElementException;

final class $Iterators$8
  extends .UnmodifiableIterator<T>
{
  boolean done;
  
  $Iterators$8(Object paramObject) {}
  
  public boolean hasNext()
  {
    return !done;
  }
  
  public T next()
  {
    if (done) {
      throw new NoSuchElementException();
    }
    done = true;
    return (T)val$value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterators.8
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
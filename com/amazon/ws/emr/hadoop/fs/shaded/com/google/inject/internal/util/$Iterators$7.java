package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.NoSuchElementException;

final class $Iterators$7
  extends .UnmodifiableIterator<T>
{
  int i = val$offset;
  
  $Iterators$7(int paramInt1, int paramInt2, Object[] paramArrayOfObject) {}
  
  public boolean hasNext()
  {
    return i < val$end;
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return (T)val$array[(i++)];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterators.7
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
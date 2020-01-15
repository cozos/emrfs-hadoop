package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.NoSuchElementException;

final class $Iterators$6
  extends .UnmodifiableIterator<T>
{
  final int length = val$array.length;
  int i = 0;
  
  $Iterators$6(Object[] paramArrayOfObject) {}
  
  public boolean hasNext()
  {
    return i < length;
  }
  
  public T next()
  {
    try
    {
      T t = val$array[i];
      i += 1;
      return t;
    }
    catch (ArrayIndexOutOfBoundsException e)
    {
      throw new NoSuchElementException();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterators.6
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.NoSuchElementException;

final class Iterators$1
  extends UnmodifiableListIterator<Object>
{
  public boolean hasNext()
  {
    return false;
  }
  
  public Object next()
  {
    throw new NoSuchElementException();
  }
  
  public boolean hasPrevious()
  {
    return false;
  }
  
  public Object previous()
  {
    throw new NoSuchElementException();
  }
  
  public int nextIndex()
  {
    return 0;
  }
  
  public int previousIndex()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
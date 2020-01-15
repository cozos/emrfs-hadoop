package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

class SmallSortedMap$EmptySet
{
  private static final Iterator<Object> ITERATOR = new Iterator()
  {
    public boolean hasNext()
    {
      return false;
    }
    
    public Object next()
    {
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  };
  private static final Iterable<Object> ITERABLE = new Iterable()
  {
    public Iterator<Object> iterator()
    {
      return SmallSortedMap.EmptySet.ITERATOR;
    }
  };
  
  static <T> Iterable<T> iterable()
  {
    return ITERABLE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.SmallSortedMap.EmptySet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
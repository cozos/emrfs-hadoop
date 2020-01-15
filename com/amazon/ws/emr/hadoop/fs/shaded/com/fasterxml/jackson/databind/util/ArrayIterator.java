package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T>
  implements Iterator<T>, Iterable<T>
{
  private final T[] _a;
  private int _index;
  
  public ArrayIterator(T[] a)
  {
    _a = a;
    _index = 0;
  }
  
  public boolean hasNext()
  {
    return _index < _a.length;
  }
  
  public T next()
  {
    if (_index >= _a.length) {
      throw new NoSuchElementException();
    }
    return (T)_a[(_index++)];
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  public Iterator<T> iterator()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
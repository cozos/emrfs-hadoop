package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Enumeration;

final class Iterators$13
  extends UnmodifiableIterator<T>
{
  Iterators$13(Enumeration paramEnumeration) {}
  
  public boolean hasNext()
  {
    return val$enumeration.hasMoreElements();
  }
  
  public T next()
  {
    return (T)val$enumeration.nextElement();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
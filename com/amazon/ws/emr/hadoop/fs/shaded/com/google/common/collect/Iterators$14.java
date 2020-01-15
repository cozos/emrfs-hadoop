package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Enumeration;
import java.util.Iterator;

final class Iterators$14
  implements Enumeration<T>
{
  Iterators$14(Iterator paramIterator) {}
  
  public boolean hasMoreElements()
  {
    return val$iterator.hasNext();
  }
  
  public T nextElement()
  {
    return (T)val$iterator.next();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
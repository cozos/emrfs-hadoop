package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Enumeration;
import java.util.Iterator;

final class $Iterators$9
  implements Enumeration<T>
{
  $Iterators$9(Iterator paramIterator) {}
  
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterators.9
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
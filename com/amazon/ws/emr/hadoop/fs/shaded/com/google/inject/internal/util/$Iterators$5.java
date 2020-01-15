package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;

final class $Iterators$5
  implements Iterator<T>
{
  $Iterators$5(Iterator paramIterator, .Function paramFunction) {}
  
  public boolean hasNext()
  {
    return val$fromIterator.hasNext();
  }
  
  public T next()
  {
    F from = val$fromIterator.next();
    return (T)val$function.apply(from);
  }
  
  public void remove()
  {
    val$fromIterator.remove();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterators.5
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
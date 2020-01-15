package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;

final class $Iterables$3
  extends .Iterables.IterableWithToString<T>
{
  $Iterables$3(Iterable paramIterable, .Function paramFunction) {}
  
  public Iterator<T> iterator()
  {
    return .Iterators.transform(val$fromIterable.iterator(), val$function);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterables.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
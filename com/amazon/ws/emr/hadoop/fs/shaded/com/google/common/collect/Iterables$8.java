package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Iterator;

final class Iterables$8
  extends FluentIterable<T>
{
  Iterables$8(Iterable paramIterable, Function paramFunction) {}
  
  public Iterator<T> iterator()
  {
    return Iterators.transform(val$fromIterable.iterator(), val$function);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
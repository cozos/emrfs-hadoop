package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Iterator;

final class Iterators$7
  extends AbstractIterator<T>
{
  Iterators$7(Iterator paramIterator, Predicate paramPredicate) {}
  
  protected T computeNext()
  {
    while (val$unfiltered.hasNext())
    {
      T element = val$unfiltered.next();
      if (val$predicate.apply(element)) {
        return element;
      }
    }
    return (T)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

final class Iterables$3
  extends TransformedIterator<Iterable<? extends T>, Iterator<? extends T>>
{
  Iterables$3(Iterator x0)
  {
    super(x0);
  }
  
  Iterator<? extends T> transform(Iterable<? extends T> from)
  {
    return from.iterator();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
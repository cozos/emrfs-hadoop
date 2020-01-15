package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;

@GwtCompatible
abstract class TransformedIterator<F, T>
  implements Iterator<T>
{
  final Iterator<? extends F> backingIterator;
  
  TransformedIterator(Iterator<? extends F> backingIterator)
  {
    this.backingIterator = ((Iterator)Preconditions.checkNotNull(backingIterator));
  }
  
  abstract T transform(F paramF);
  
  public final boolean hasNext()
  {
    return backingIterator.hasNext();
  }
  
  public final T next()
  {
    return (T)transform(backingIterator.next());
  }
  
  public final void remove()
  {
    backingIterator.remove();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TransformedIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
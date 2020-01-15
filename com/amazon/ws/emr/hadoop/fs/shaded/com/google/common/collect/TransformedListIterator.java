package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible
abstract class TransformedListIterator<F, T>
  extends TransformedIterator<F, T>
  implements ListIterator<T>
{
  TransformedListIterator(ListIterator<? extends F> backingIterator)
  {
    super(backingIterator);
  }
  
  private ListIterator<? extends F> backingIterator()
  {
    return Iterators.cast(backingIterator);
  }
  
  public final boolean hasPrevious()
  {
    return backingIterator().hasPrevious();
  }
  
  public final T previous()
  {
    return (T)transform(backingIterator().previous());
  }
  
  public final int nextIndex()
  {
    return backingIterator().nextIndex();
  }
  
  public final int previousIndex()
  {
    return backingIterator().previousIndex();
  }
  
  public void set(T element)
  {
    throw new UnsupportedOperationException();
  }
  
  public void add(T element)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TransformedListIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
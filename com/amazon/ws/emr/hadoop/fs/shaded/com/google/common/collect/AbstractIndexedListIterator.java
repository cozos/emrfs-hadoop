package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class AbstractIndexedListIterator<E>
  extends UnmodifiableListIterator<E>
{
  private final int size;
  private int position;
  
  protected abstract E get(int paramInt);
  
  protected AbstractIndexedListIterator(int size)
  {
    this(size, 0);
  }
  
  protected AbstractIndexedListIterator(int size, int position)
  {
    Preconditions.checkPositionIndex(position, size);
    this.size = size;
    this.position = position;
  }
  
  public final boolean hasNext()
  {
    return position < size;
  }
  
  public final E next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return (E)get(position++);
  }
  
  public final int nextIndex()
  {
    return position;
  }
  
  public final boolean hasPrevious()
  {
    return position > 0;
  }
  
  public final E previous()
  {
    if (!hasPrevious()) {
      throw new NoSuchElementException();
    }
    return (E)get(--position);
  }
  
  public final int previousIndex()
  {
    return position - 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractIndexedListIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
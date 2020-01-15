package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;

@GwtCompatible(emulated=true)
class RegularImmutableAsList<E>
  extends ImmutableAsList<E>
{
  private final ImmutableCollection<E> delegate;
  private final ImmutableList<? extends E> delegateList;
  
  RegularImmutableAsList(ImmutableCollection<E> delegate, ImmutableList<? extends E> delegateList)
  {
    this.delegate = delegate;
    this.delegateList = delegateList;
  }
  
  RegularImmutableAsList(ImmutableCollection<E> delegate, Object[] array)
  {
    this(delegate, ImmutableList.asImmutableList(array));
  }
  
  ImmutableCollection<E> delegateCollection()
  {
    return delegate;
  }
  
  ImmutableList<? extends E> delegateList()
  {
    return delegateList;
  }
  
  public UnmodifiableListIterator<E> listIterator(int index)
  {
    return delegateList.listIterator(index);
  }
  
  @GwtIncompatible("not present in emulated superclass")
  int copyIntoArray(Object[] dst, int offset)
  {
    return delegateList.copyIntoArray(dst, offset);
  }
  
  public E get(int index)
  {
    return (E)delegateList.get(index);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableAsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
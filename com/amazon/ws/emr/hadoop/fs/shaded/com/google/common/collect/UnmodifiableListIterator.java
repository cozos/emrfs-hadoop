package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible
public abstract class UnmodifiableListIterator<E>
  extends UnmodifiableIterator<E>
  implements ListIterator<E>
{
  @Deprecated
  public final void add(E e)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void set(E e)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.UnmodifiableListIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
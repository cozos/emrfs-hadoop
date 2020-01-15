package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;
import javax.annotation.Nullable;

final class Multisets$ImmutableEntry<E>
  extends Multisets.AbstractEntry<E>
  implements Serializable
{
  @Nullable
  final E element;
  final int count;
  private static final long serialVersionUID = 0L;
  
  Multisets$ImmutableEntry(@Nullable E element, int count)
  {
    this.element = element;
    this.count = count;
    CollectPreconditions.checkNonnegative(count, "count");
  }
  
  @Nullable
  public E getElement()
  {
    return (E)element;
  }
  
  public int getCount()
  {
    return count;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.ImmutableEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
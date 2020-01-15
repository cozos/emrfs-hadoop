package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

class ImmutableSortedSet$SerializedForm<E>
  implements Serializable
{
  final Comparator<? super E> comparator;
  final Object[] elements;
  private static final long serialVersionUID = 0L;
  
  public ImmutableSortedSet$SerializedForm(Comparator<? super E> comparator, Object[] elements)
  {
    this.comparator = comparator;
    this.elements = elements;
  }
  
  Object readResolve()
  {
    return new ImmutableSortedSet.Builder(comparator).add((Object[])elements).build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSortedSet.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
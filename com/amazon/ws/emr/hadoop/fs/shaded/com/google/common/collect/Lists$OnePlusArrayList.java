package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class Lists$OnePlusArrayList<E>
  extends AbstractList<E>
  implements Serializable, RandomAccess
{
  final E first;
  final E[] rest;
  private static final long serialVersionUID = 0L;
  
  Lists$OnePlusArrayList(@Nullable E first, E[] rest)
  {
    this.first = first;
    this.rest = ((Object[])Preconditions.checkNotNull(rest));
  }
  
  public int size()
  {
    return rest.length + 1;
  }
  
  public E get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    return (E)(index == 0 ? first : rest[(index - 1)]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.OnePlusArrayList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
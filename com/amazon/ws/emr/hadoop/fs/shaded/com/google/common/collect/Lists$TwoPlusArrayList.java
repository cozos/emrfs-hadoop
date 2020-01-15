package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class Lists$TwoPlusArrayList<E>
  extends AbstractList<E>
  implements Serializable, RandomAccess
{
  final E first;
  final E second;
  final E[] rest;
  private static final long serialVersionUID = 0L;
  
  Lists$TwoPlusArrayList(@Nullable E first, @Nullable E second, E[] rest)
  {
    this.first = first;
    this.second = second;
    this.rest = ((Object[])Preconditions.checkNotNull(rest));
  }
  
  public int size()
  {
    return rest.length + 2;
  }
  
  public E get(int index)
  {
    switch (index)
    {
    case 0: 
      return (E)first;
    case 1: 
      return (E)second;
    }
    Preconditions.checkElementIndex(index, size());
    return (E)rest[(index - 2)];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.TwoPlusArrayList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
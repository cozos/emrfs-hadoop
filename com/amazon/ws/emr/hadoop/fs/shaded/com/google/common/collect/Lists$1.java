package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.List;
import java.util.ListIterator;

final class Lists$1
  extends Lists.RandomAccessListWrapper<E>
{
  private static final long serialVersionUID = 0L;
  
  Lists$1(List x0)
  {
    super(x0);
  }
  
  public ListIterator<E> listIterator(int index)
  {
    return backingList.listIterator(index);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
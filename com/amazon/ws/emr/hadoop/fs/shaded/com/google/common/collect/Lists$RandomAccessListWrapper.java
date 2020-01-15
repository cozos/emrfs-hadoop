package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;

class Lists$RandomAccessListWrapper<E>
  extends Lists.AbstractListWrapper<E>
  implements RandomAccess
{
  Lists$RandomAccessListWrapper(List<E> backingList)
  {
    super(backingList);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.RandomAccessListWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
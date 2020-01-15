package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;

class Lists$RandomAccessPartition<T>
  extends Lists.Partition<T>
  implements RandomAccess
{
  Lists$RandomAccessPartition(List<T> list, int size)
  {
    super(list, size);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.RandomAccessPartition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
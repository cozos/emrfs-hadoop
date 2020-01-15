package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;

class Lists$RandomAccessReverseList<T>
  extends Lists.ReverseList<T>
  implements RandomAccess
{
  Lists$RandomAccessReverseList(List<T> forwardList)
  {
    super(forwardList);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.RandomAccessReverseList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
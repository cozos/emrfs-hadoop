package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class Synchronized$SynchronizedRandomAccessList<E>
  extends Synchronized.SynchronizedList<E>
  implements RandomAccess
{
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedRandomAccessList(List<E> list, @Nullable Object mutex)
  {
    super(list, mutex);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedRandomAccessList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
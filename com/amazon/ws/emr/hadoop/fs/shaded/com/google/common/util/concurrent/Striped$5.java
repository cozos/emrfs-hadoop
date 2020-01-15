package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

final class Striped$5
  implements Supplier<ReadWriteLock>
{
  public ReadWriteLock get()
  {
    return new ReentrantReadWriteLock();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Striped.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
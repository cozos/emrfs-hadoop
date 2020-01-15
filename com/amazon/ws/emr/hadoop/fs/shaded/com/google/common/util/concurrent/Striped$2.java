package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class Striped$2
  implements Supplier<Lock>
{
  public Lock get()
  {
    return new ReentrantLock(false);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Striped.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
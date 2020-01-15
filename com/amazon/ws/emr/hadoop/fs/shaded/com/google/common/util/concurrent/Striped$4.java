package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.concurrent.Semaphore;

final class Striped$4
  implements Supplier<Semaphore>
{
  Striped$4(int paramInt) {}
  
  public Semaphore get()
  {
    return new Semaphore(val$permits, false);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Striped.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
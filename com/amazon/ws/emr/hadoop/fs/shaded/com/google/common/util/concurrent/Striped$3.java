package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.concurrent.Semaphore;

final class Striped$3
  implements Supplier<Semaphore>
{
  Striped$3(int paramInt) {}
  
  public Semaphore get()
  {
    return new Striped.PaddedSemaphore(val$permits);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Striped.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
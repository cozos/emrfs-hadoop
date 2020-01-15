package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.util.concurrent.atomic.AtomicLong;

final class LongAddables$PureJavaLongAddable
  extends AtomicLong
  implements LongAddable
{
  public void increment()
  {
    getAndIncrement();
  }
  
  public void add(long x)
  {
    getAndAdd(x);
  }
  
  public long sum()
  {
    return get();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LongAddables.PureJavaLongAddable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
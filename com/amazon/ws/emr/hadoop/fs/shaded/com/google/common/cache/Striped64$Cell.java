package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import sun.misc.Unsafe;

final class Striped64$Cell
{
  volatile long p0;
  volatile long p1;
  volatile long p2;
  volatile long p3;
  volatile long p4;
  volatile long p5;
  volatile long p6;
  volatile long value;
  volatile long q0;
  volatile long q1;
  volatile long q2;
  volatile long q3;
  volatile long q4;
  volatile long q5;
  volatile long q6;
  private static final Unsafe UNSAFE;
  private static final long valueOffset;
  
  Striped64$Cell(long x)
  {
    value = x;
  }
  
  final boolean cas(long cmp, long val)
  {
    return UNSAFE.compareAndSwapLong(this, valueOffset, cmp, val);
  }
  
  static
  {
    try
    {
      UNSAFE = Striped64.access$000();
      Class<?> ak = Cell.class;
      valueOffset = UNSAFE.objectFieldOffset(ak.getDeclaredField("value"));
    }
    catch (Exception e)
    {
      throw new Error(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.Striped64.Cell
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
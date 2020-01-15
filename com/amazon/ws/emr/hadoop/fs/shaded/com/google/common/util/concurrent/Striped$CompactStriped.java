package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;

class Striped$CompactStriped<L>
  extends Striped.PowerOfTwoStriped<L>
{
  private final Object[] array;
  
  private Striped$CompactStriped(int stripes, Supplier<L> supplier)
  {
    super(stripes);
    Preconditions.checkArgument(stripes <= 1073741824, "Stripes must be <= 2^30)");
    
    array = new Object[mask + 1];
    for (int i = 0; i < array.length; i++) {
      array[i] = supplier.get();
    }
  }
  
  public L getAt(int index)
  {
    return (L)array[index];
  }
  
  public int size()
  {
    return array.length;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Striped.CompactStriped
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
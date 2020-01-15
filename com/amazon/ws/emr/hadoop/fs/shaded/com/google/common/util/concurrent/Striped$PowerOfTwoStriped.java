package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

abstract class Striped$PowerOfTwoStriped<L>
  extends Striped<L>
{
  final int mask;
  
  Striped$PowerOfTwoStriped(int stripes)
  {
    super(null);
    Preconditions.checkArgument(stripes > 0, "Stripes must be positive");
    mask = (stripes > 1073741824 ? -1 : Striped.access$200(stripes) - 1);
  }
  
  final int indexFor(Object key)
  {
    int hash = Striped.access$300(key.hashCode());
    return hash & mask;
  }
  
  public final L get(Object key)
  {
    return (L)getAt(indexFor(key));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Striped.PowerOfTwoStriped
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
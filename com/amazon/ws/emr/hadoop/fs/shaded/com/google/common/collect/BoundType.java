package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;

@GwtCompatible
public enum BoundType
{
  OPEN,  CLOSED;
  
  private BoundType() {}
  
  static BoundType forBoolean(boolean inclusive)
  {
    return inclusive ? CLOSED : OPEN;
  }
  
  abstract BoundType flip();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.BoundType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
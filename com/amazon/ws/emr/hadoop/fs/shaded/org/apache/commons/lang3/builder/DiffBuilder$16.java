package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ArrayUtils;

class DiffBuilder$16
  extends Diff<Short[]>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$16(DiffBuilder paramDiffBuilder, String x0, short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    super(x0);
  }
  
  public Short[] getLeft()
  {
    return ArrayUtils.toObject(val$lhs);
  }
  
  public Short[] getRight()
  {
    return ArrayUtils.toObject(val$rhs);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.DiffBuilder.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
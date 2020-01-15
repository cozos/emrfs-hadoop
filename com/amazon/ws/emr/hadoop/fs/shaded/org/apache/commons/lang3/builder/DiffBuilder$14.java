package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ArrayUtils;

class DiffBuilder$14
  extends Diff<Long[]>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$14(DiffBuilder paramDiffBuilder, String x0, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    super(x0);
  }
  
  public Long[] getLeft()
  {
    return ArrayUtils.toObject(val$lhs);
  }
  
  public Long[] getRight()
  {
    return ArrayUtils.toObject(val$rhs);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.DiffBuilder.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
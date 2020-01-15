package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ArrayUtils;

class DiffBuilder$10
  extends Diff<Float[]>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$10(DiffBuilder paramDiffBuilder, String x0, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    super(x0);
  }
  
  public Float[] getLeft()
  {
    return ArrayUtils.toObject(val$lhs);
  }
  
  public Float[] getRight()
  {
    return ArrayUtils.toObject(val$rhs);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.DiffBuilder.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
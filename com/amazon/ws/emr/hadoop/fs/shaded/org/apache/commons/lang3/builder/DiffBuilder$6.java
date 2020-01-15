package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ArrayUtils;

class DiffBuilder$6
  extends Diff<Character[]>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$6(DiffBuilder paramDiffBuilder, String x0, char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    super(x0);
  }
  
  public Character[] getLeft()
  {
    return ArrayUtils.toObject(val$lhs);
  }
  
  public Character[] getRight()
  {
    return ArrayUtils.toObject(val$rhs);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.DiffBuilder.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
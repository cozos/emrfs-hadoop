package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder;

class DiffBuilder$3
  extends Diff<Byte>
{
  private static final long serialVersionUID = 1L;
  
  DiffBuilder$3(DiffBuilder paramDiffBuilder, String x0, byte paramByte1, byte paramByte2)
  {
    super(x0);
  }
  
  public Byte getLeft()
  {
    return Byte.valueOf(val$lhs);
  }
  
  public Byte getRight()
  {
    return Byte.valueOf(val$rhs);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.DiffBuilder.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
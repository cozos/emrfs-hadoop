package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

public class DimensionMismatchException
  extends MathException
{
  private static final long serialVersionUID = -1316089546353786411L;
  private final int dimension1;
  private final int dimension2;
  
  public DimensionMismatchException(int dimension1, int dimension2)
  {
    super("dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(dimension1), Integer.valueOf(dimension2) });
    this.dimension1 = dimension1;
    this.dimension2 = dimension2;
  }
  
  public int getDimension1()
  {
    return dimension1;
  }
  
  public int getDimension2()
  {
    return dimension2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.DimensionMismatchException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
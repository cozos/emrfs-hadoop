package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

public class NonSquareMatrixException
  extends InvalidMatrixException
{
  private static final long serialVersionUID = 8996207526636673730L;
  
  public NonSquareMatrixException(int rows, int columns)
  {
    super("a {0}x{1} matrix was provided instead of a square matrix", new Object[] { Integer.valueOf(rows), Integer.valueOf(columns) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.NonSquareMatrixException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
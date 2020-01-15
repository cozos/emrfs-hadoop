package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

public class DefaultRealMatrixChangingVisitor
  implements RealMatrixChangingVisitor
{
  public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {}
  
  public double visit(int row, int column, double value)
    throws MatrixVisitorException
  {
    return value;
  }
  
  public double end()
  {
    return 0.0D;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.DefaultRealMatrixChangingVisitor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
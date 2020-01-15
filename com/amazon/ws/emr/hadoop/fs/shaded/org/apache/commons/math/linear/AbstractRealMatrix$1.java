package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

class AbstractRealMatrix$1
  implements RealMatrixPreservingVisitor
{
  private double endRow;
  private double columnSum;
  private double maxColSum;
  
  AbstractRealMatrix$1(AbstractRealMatrix paramAbstractRealMatrix) {}
  
  public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn)
  {
    this.endRow = endRow;
    columnSum = 0.0D;
    maxColSum = 0.0D;
  }
  
  public void visit(int row, int column, double value)
  {
    columnSum += Math.abs(value);
    if (row == endRow)
    {
      maxColSum = Math.max(maxColSum, columnSum);
      columnSum = 0.0D;
    }
  }
  
  public double end()
  {
    return maxColSum;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.AbstractRealMatrix.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
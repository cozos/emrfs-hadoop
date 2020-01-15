package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

class AbstractRealMatrix$2
  implements RealMatrixPreservingVisitor
{
  private double sum;
  
  AbstractRealMatrix$2(AbstractRealMatrix paramAbstractRealMatrix) {}
  
  public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn)
  {
    sum = 0.0D;
  }
  
  public void visit(int row, int column, double value)
  {
    sum += value * value;
  }
  
  public double end()
  {
    return Math.sqrt(sum);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.AbstractRealMatrix.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
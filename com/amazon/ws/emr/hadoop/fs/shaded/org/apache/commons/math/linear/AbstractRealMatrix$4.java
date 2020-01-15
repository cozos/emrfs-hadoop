package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

class AbstractRealMatrix$4
  extends DefaultRealMatrixPreservingVisitor
{
  private int startRow;
  private int startColumn;
  
  AbstractRealMatrix$4(AbstractRealMatrix paramAbstractRealMatrix, double[][] paramArrayOfDouble) {}
  
  public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn)
  {
    this.startRow = startRow;
    this.startColumn = startColumn;
  }
  
  public void visit(int row, int column, double value)
  {
    val$destination[(row - startRow)][(column - startColumn)] = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.AbstractRealMatrix.4
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
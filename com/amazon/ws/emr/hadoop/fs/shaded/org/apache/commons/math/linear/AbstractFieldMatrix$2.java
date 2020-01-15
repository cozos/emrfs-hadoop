package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FieldElement;

class AbstractFieldMatrix$2
  extends DefaultFieldMatrixPreservingVisitor<T>
{
  private int startRow;
  private int startColumn;
  
  AbstractFieldMatrix$2(AbstractFieldMatrix paramAbstractFieldMatrix, FieldElement x0, FieldElement[][] paramArrayOfFieldElement)
  {
    super(x0);
  }
  
  public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn)
  {
    this.startRow = startRow;
    this.startColumn = startColumn;
  }
  
  public void visit(int row, int column, T value)
  {
    val$destination[(row - startRow)][(column - startColumn)] = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.AbstractFieldMatrix.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
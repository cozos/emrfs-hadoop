package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

class AbstractRealMatrix$3
  extends DefaultRealMatrixChangingVisitor
{
  AbstractRealMatrix$3(AbstractRealMatrix paramAbstractRealMatrix, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public double visit(int row, int column, double value)
  {
    return this$0.getEntry(val$selectedRows[row], val$selectedColumns[column]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.AbstractRealMatrix.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
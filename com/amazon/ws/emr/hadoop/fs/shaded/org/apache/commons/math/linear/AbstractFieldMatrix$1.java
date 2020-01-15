package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FieldElement;

class AbstractFieldMatrix$1
  extends DefaultFieldMatrixChangingVisitor<T>
{
  AbstractFieldMatrix$1(AbstractFieldMatrix paramAbstractFieldMatrix, FieldElement x0, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    super(x0);
  }
  
  public T visit(int row, int column, T value)
  {
    return this$0.getEntry(val$selectedRows[row], val$selectedColumns[column]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.AbstractFieldMatrix.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
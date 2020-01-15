package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FieldElement;

class AbstractFieldMatrix$3
  extends DefaultFieldMatrixPreservingVisitor<T>
{
  AbstractFieldMatrix$3(AbstractFieldMatrix paramAbstractFieldMatrix, FieldElement x0, FieldMatrix paramFieldMatrix)
  {
    super(x0);
  }
  
  public void visit(int row, int column, T value)
  {
    val$out.setEntry(column, row, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.AbstractFieldMatrix.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
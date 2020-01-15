package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

class AbstractRealMatrix$5
  extends DefaultRealMatrixPreservingVisitor
{
  AbstractRealMatrix$5(AbstractRealMatrix paramAbstractRealMatrix, RealMatrix paramRealMatrix) {}
  
  public void visit(int row, int column, double value)
  {
    val$out.setEntry(column, row, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.AbstractRealMatrix.5
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
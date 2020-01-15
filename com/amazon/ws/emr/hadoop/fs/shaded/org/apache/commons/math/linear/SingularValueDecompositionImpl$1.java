package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

class SingularValueDecompositionImpl$1
  extends DefaultRealMatrixPreservingVisitor
{
  SingularValueDecompositionImpl$1(SingularValueDecompositionImpl paramSingularValueDecompositionImpl, double[][] paramArrayOfDouble) {}
  
  public void visit(int row, int column, double value)
  {
    val$data[row][column] = (value / SingularValueDecompositionImpl.access$000(this$0)[row]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.SingularValueDecompositionImpl.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
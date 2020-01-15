package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FieldElement;

public class DefaultFieldMatrixPreservingVisitor<T extends FieldElement<T>>
  implements FieldMatrixPreservingVisitor<T>
{
  private final T zero;
  
  public DefaultFieldMatrixPreservingVisitor(T zero)
  {
    this.zero = zero;
  }
  
  public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {}
  
  public void visit(int row, int column, T value)
    throws MatrixVisitorException
  {}
  
  public T end()
  {
    return zero;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.DefaultFieldMatrixPreservingVisitor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
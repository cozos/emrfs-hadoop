package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FieldElement;

public class DefaultFieldMatrixChangingVisitor<T extends FieldElement<T>>
  implements FieldMatrixChangingVisitor<T>
{
  private final T zero;
  
  public DefaultFieldMatrixChangingVisitor(T zero)
  {
    this.zero = zero;
  }
  
  public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {}
  
  public T visit(int row, int column, T value)
    throws MatrixVisitorException
  {
    return value;
  }
  
  public T end()
  {
    return zero;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.DefaultFieldMatrixChangingVisitor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
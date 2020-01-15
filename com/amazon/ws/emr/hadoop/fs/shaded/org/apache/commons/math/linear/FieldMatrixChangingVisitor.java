package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FieldElement;

public abstract interface FieldMatrixChangingVisitor<T extends FieldElement<?>>
{
  public abstract void start(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract T visit(int paramInt1, int paramInt2, T paramT)
    throws MatrixVisitorException;
  
  public abstract T end();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.FieldMatrixChangingVisitor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
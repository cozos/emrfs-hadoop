package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FieldElement;

public abstract interface FieldLUDecomposition<T extends FieldElement<T>>
{
  public abstract FieldMatrix<T> getL();
  
  public abstract FieldMatrix<T> getU();
  
  public abstract FieldMatrix<T> getP();
  
  public abstract int[] getPivot();
  
  public abstract T getDeterminant();
  
  public abstract FieldDecompositionSolver<T> getSolver();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.FieldLUDecomposition
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
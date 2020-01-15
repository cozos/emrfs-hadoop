package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

public abstract interface CholeskyDecomposition
{
  public abstract RealMatrix getL();
  
  public abstract RealMatrix getLT();
  
  public abstract double getDeterminant();
  
  public abstract DecompositionSolver getSolver();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.CholeskyDecomposition
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
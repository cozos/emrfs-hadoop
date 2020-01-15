package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

public abstract interface LUDecomposition
{
  public abstract RealMatrix getL();
  
  public abstract RealMatrix getU();
  
  public abstract RealMatrix getP();
  
  public abstract int[] getPivot();
  
  public abstract double getDeterminant();
  
  public abstract DecompositionSolver getSolver();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.LUDecomposition
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
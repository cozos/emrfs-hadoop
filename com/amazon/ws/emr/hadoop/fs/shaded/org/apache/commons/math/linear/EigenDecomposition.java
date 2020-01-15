package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

public abstract interface EigenDecomposition
{
  public abstract RealMatrix getV();
  
  public abstract RealMatrix getD();
  
  public abstract RealMatrix getVT();
  
  public abstract double[] getRealEigenvalues();
  
  public abstract double getRealEigenvalue(int paramInt);
  
  public abstract double[] getImagEigenvalues();
  
  public abstract double getImagEigenvalue(int paramInt);
  
  public abstract RealVector getEigenvector(int paramInt);
  
  public abstract double getDeterminant();
  
  public abstract DecompositionSolver getSolver();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.EigenDecomposition
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
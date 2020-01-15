package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

public abstract interface DecompositionSolver
{
  public abstract double[] solve(double[] paramArrayOfDouble)
    throws IllegalArgumentException, InvalidMatrixException;
  
  public abstract RealVector solve(RealVector paramRealVector)
    throws IllegalArgumentException, InvalidMatrixException;
  
  public abstract RealMatrix solve(RealMatrix paramRealMatrix)
    throws IllegalArgumentException, InvalidMatrixException;
  
  public abstract boolean isNonSingular();
  
  public abstract RealMatrix getInverse()
    throws InvalidMatrixException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.DecompositionSolver
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
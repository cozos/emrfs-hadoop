package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

public abstract interface QRDecomposition
{
  public abstract RealMatrix getR();
  
  public abstract RealMatrix getQ();
  
  public abstract RealMatrix getQT();
  
  public abstract RealMatrix getH();
  
  public abstract DecompositionSolver getSolver();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.QRDecomposition
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
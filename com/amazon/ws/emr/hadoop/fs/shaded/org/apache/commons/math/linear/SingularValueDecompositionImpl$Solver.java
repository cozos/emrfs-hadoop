package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

class SingularValueDecompositionImpl$Solver
  implements DecompositionSolver
{
  private final RealMatrix pseudoInverse;
  private boolean nonSingular;
  
  private SingularValueDecompositionImpl$Solver(double[] singularValues, RealMatrix uT, RealMatrix v, boolean nonSingular)
  {
    double[][] suT = uT.getData();
    for (int i = 0; i < singularValues.length; i++)
    {
      double a;
      double a;
      if (singularValues[i] > 0.0D) {
        a = 1.0D / singularValues[i];
      } else {
        a = 0.0D;
      }
      double[] suTi = suT[i];
      for (int j = 0; j < suTi.length; j++) {
        suTi[j] *= a;
      }
    }
    pseudoInverse = v.multiply(new Array2DRowRealMatrix(suT, false));
    this.nonSingular = nonSingular;
  }
  
  public double[] solve(double[] b)
    throws IllegalArgumentException
  {
    return pseudoInverse.operate(b);
  }
  
  public RealVector solve(RealVector b)
    throws IllegalArgumentException
  {
    return pseudoInverse.operate(b);
  }
  
  public RealMatrix solve(RealMatrix b)
    throws IllegalArgumentException
  {
    return pseudoInverse.multiply(b);
  }
  
  public boolean isNonSingular()
  {
    return nonSingular;
  }
  
  public RealMatrix getInverse()
  {
    return pseudoInverse;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.SingularValueDecompositionImpl.Solver
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
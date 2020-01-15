package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general;

class NonLinearConjugateGradientOptimizer$IdentityPreconditioner
  implements Preconditioner
{
  public double[] precondition(double[] variables, double[] r)
  {
    return (double[])r.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general.NonLinearConjugateGradientOptimizer.IdentityPreconditioner
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
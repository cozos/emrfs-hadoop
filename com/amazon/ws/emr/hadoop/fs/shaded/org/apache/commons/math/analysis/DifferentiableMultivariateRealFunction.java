package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis;

public abstract interface DifferentiableMultivariateRealFunction
  extends MultivariateRealFunction
{
  public abstract MultivariateRealFunction partialDerivative(int paramInt);
  
  public abstract MultivariateVectorialFunction gradient();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.DifferentiableMultivariateRealFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
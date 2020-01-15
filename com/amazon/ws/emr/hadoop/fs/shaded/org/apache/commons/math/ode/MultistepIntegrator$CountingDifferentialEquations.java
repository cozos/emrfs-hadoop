package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

class MultistepIntegrator$CountingDifferentialEquations
  implements FirstOrderDifferentialEquations
{
  private final int dimension;
  
  public MultistepIntegrator$CountingDifferentialEquations(MultistepIntegrator paramMultistepIntegrator, int dimension)
  {
    this.dimension = dimension;
  }
  
  public void computeDerivatives(double t, double[] y, double[] dot)
    throws DerivativeException
  {
    this$0.computeDerivatives(t, y, dot);
  }
  
  public int getDimension()
  {
    return dimension;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.MultistepIntegrator.CountingDifferentialEquations
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
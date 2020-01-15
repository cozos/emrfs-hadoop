package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

public class GillIntegrator
  extends RungeKuttaIntegrator
{
  private static final double[] STATIC_C = { 0.5D, 0.5D, 1.0D };
  private static final double[][] STATIC_A = { { 0.5D }, { (Math.sqrt(2.0D) - 1.0D) / 2.0D, (2.0D - Math.sqrt(2.0D)) / 2.0D }, { 0.0D, -Math.sqrt(2.0D) / 2.0D, (2.0D + Math.sqrt(2.0D)) / 2.0D } };
  private static final double[] STATIC_B = { 0.16666666666666666D, (2.0D - Math.sqrt(2.0D)) / 6.0D, (2.0D + Math.sqrt(2.0D)) / 6.0D, 0.16666666666666666D };
  
  public GillIntegrator(double step)
  {
    super("Gill", STATIC_C, STATIC_A, STATIC_B, new GillStepInterpolator(), step);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.GillIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
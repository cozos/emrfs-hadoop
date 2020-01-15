package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.Array2DRowRealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.AdaptiveStepsizeIntegrator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.DormandPrince853Integrator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepInterpolator;

public abstract class MultistepIntegrator
  extends AdaptiveStepsizeIntegrator
{
  protected double[] scaled;
  protected Array2DRowRealMatrix nordsieck;
  private FirstOrderIntegrator starter;
  private final int nSteps;
  private double exp;
  private double safety;
  private double minReduction;
  private double maxGrowth;
  
  protected MultistepIntegrator(String name, int nSteps, int order, double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance)
  {
    super(name, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
    if (nSteps <= 0) {
      throw MathRuntimeException.createIllegalArgumentException("{0} method needs at least one previous point", new Object[] { name });
    }
    starter = new DormandPrince853Integrator(minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
    
    this.nSteps = nSteps;
    
    exp = (-1.0D / order);
    
    setSafety(0.9D);
    setMinReduction(0.2D);
    setMaxGrowth(Math.pow(2.0D, -exp));
  }
  
  protected MultistepIntegrator(String name, int nSteps, int order, double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance)
  {
    super(name, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
    starter = new DormandPrince853Integrator(minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
    
    this.nSteps = nSteps;
    
    exp = (-1.0D / order);
    
    setSafety(0.9D);
    setMinReduction(0.2D);
    setMaxGrowth(Math.pow(2.0D, -exp));
  }
  
  public ODEIntegrator getStarterIntegrator()
  {
    return starter;
  }
  
  public void setStarterIntegrator(FirstOrderIntegrator starterIntegrator)
  {
    starter = starterIntegrator;
  }
  
  protected void start(double t0, double[] y0, double t)
    throws DerivativeException, IntegratorException
  {
    starter.clearEventHandlers();
    starter.clearStepHandlers();
    
    starter.addStepHandler(new NordsieckInitializer(y0.length));
    try
    {
      starter.integrate(new CountingDifferentialEquations(y0.length), t0, y0, t, new double[y0.length]);
    }
    catch (DerivativeException de)
    {
      if (!(de instanceof InitializationCompletedMarkerException)) {
        throw de;
      }
    }
    starter.clearStepHandlers();
  }
  
  protected abstract Array2DRowRealMatrix initializeHighOrderDerivatives(double[] paramArrayOfDouble, double[][] paramArrayOfDouble1);
  
  public double getMinReduction()
  {
    return minReduction;
  }
  
  public void setMinReduction(double minReduction)
  {
    this.minReduction = minReduction;
  }
  
  public double getMaxGrowth()
  {
    return maxGrowth;
  }
  
  public void setMaxGrowth(double maxGrowth)
  {
    this.maxGrowth = maxGrowth;
  }
  
  public double getSafety()
  {
    return safety;
  }
  
  public void setSafety(double safety)
  {
    this.safety = safety;
  }
  
  protected double computeStepGrowShrinkFactor(double error)
  {
    return Math.min(maxGrowth, Math.max(minReduction, safety * Math.pow(error, exp)));
  }
  
  public static abstract interface NordsieckTransformer
  {
    public abstract RealMatrix initializeHighOrderDerivatives(double[] paramArrayOfDouble, double[][] paramArrayOfDouble1);
  }
  
  private class NordsieckInitializer
    implements StepHandler
  {
    private final int n;
    
    public NordsieckInitializer(int n)
    {
      this.n = n;
    }
    
    public void handleStep(StepInterpolator interpolator, boolean isLast)
      throws DerivativeException
    {
      double prev = interpolator.getPreviousTime();
      double curr = interpolator.getCurrentTime();
      stepStart = prev;
      stepSize = ((curr - prev) / (nSteps + 1));
      
      interpolator.setInterpolatedTime(prev);
      scaled = ((double[])interpolator.getInterpolatedDerivatives().clone());
      for (int j = 0; j < n; j++) {
        scaled[j] *= stepSize;
      }
      double[][] multistep = new double[nSteps][];
      for (int i = 1; i <= nSteps; i++)
      {
        interpolator.setInterpolatedTime(prev + stepSize * i);
        double[] msI = (double[])interpolator.getInterpolatedDerivatives().clone();
        for (int j = 0; j < n; j++) {
          msI[j] *= stepSize;
        }
        multistep[(i - 1)] = msI;
      }
      nordsieck = initializeHighOrderDerivatives(scaled, multistep);
      
      throw new MultistepIntegrator.InitializationCompletedMarkerException();
    }
    
    public boolean requiresDenseOutput()
    {
      return true;
    }
    
    public void reset() {}
  }
  
  private static class InitializationCompletedMarkerException
    extends DerivativeException
  {
    private static final long serialVersionUID = -4105805787353488365L;
    
    public InitializationCompletedMarkerException()
    {
      super();
    }
  }
  
  private class CountingDifferentialEquations
    implements FirstOrderDifferentialEquations
  {
    private final int dimension;
    
    public CountingDifferentialEquations(int dimension)
    {
      this.dimension = dimension;
    }
    
    public void computeDerivatives(double t, double[] y, double[] dot)
      throws DerivativeException
    {
      MultistepIntegrator.this.computeDerivatives(t, y, dot);
    }
    
    public int getDimension()
    {
      return dimension;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.MultistepIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
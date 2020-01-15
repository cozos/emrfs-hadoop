package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.AbstractIntegrator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.IntegratorException;

public abstract class AdaptiveStepsizeIntegrator
  extends AbstractIntegrator
{
  protected final double scalAbsoluteTolerance;
  protected final double scalRelativeTolerance;
  protected final double[] vecAbsoluteTolerance;
  protected final double[] vecRelativeTolerance;
  private double initialStep;
  private final double minStep;
  private final double maxStep;
  
  public AdaptiveStepsizeIntegrator(String name, double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance)
  {
    super(name);
    
    this.minStep = Math.abs(minStep);
    this.maxStep = Math.abs(maxStep);
    initialStep = -1.0D;
    
    this.scalAbsoluteTolerance = scalAbsoluteTolerance;
    this.scalRelativeTolerance = scalRelativeTolerance;
    vecAbsoluteTolerance = null;
    vecRelativeTolerance = null;
    
    resetInternalState();
  }
  
  public AdaptiveStepsizeIntegrator(String name, double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance)
  {
    super(name);
    
    this.minStep = minStep;
    this.maxStep = maxStep;
    initialStep = -1.0D;
    
    scalAbsoluteTolerance = 0.0D;
    scalRelativeTolerance = 0.0D;
    this.vecAbsoluteTolerance = ((double[])vecAbsoluteTolerance.clone());
    this.vecRelativeTolerance = ((double[])vecRelativeTolerance.clone());
    
    resetInternalState();
  }
  
  public void setInitialStepSize(double initialStepSize)
  {
    if ((initialStepSize < minStep) || (initialStepSize > maxStep)) {
      initialStep = -1.0D;
    } else {
      initialStep = initialStepSize;
    }
  }
  
  protected void sanityChecks(FirstOrderDifferentialEquations equations, double t0, double[] y0, double t, double[] y)
    throws IntegratorException
  {
    super.sanityChecks(equations, t0, y0, t, y);
    if ((vecAbsoluteTolerance != null) && (vecAbsoluteTolerance.length != y0.length)) {
      throw new IntegratorException("dimensions mismatch: state vector has dimension {0}, absolute tolerance vector has dimension {1}", new Object[] { Integer.valueOf(y0.length), Integer.valueOf(vecAbsoluteTolerance.length) });
    }
    if ((vecRelativeTolerance != null) && (vecRelativeTolerance.length != y0.length)) {
      throw new IntegratorException("dimensions mismatch: state vector has dimension {0}, relative tolerance vector has dimension {1}", new Object[] { Integer.valueOf(y0.length), Integer.valueOf(vecRelativeTolerance.length) });
    }
  }
  
  public double initializeStep(FirstOrderDifferentialEquations equations, boolean forward, int order, double[] scale, double t0, double[] y0, double[] yDot0, double[] y1, double[] yDot1)
    throws DerivativeException
  {
    if (initialStep > 0.0D) {
      return forward ? initialStep : -initialStep;
    }
    double yOnScale2 = 0.0D;
    double yDotOnScale2 = 0.0D;
    for (int j = 0; j < y0.length; j++)
    {
      double ratio = y0[j] / scale[j];
      yOnScale2 += ratio * ratio;
      ratio = yDot0[j] / scale[j];
      yDotOnScale2 += ratio * ratio;
    }
    double h = (yOnScale2 < 1.0E-10D) || (yDotOnScale2 < 1.0E-10D) ? 1.0E-6D : 0.01D * Math.sqrt(yOnScale2 / yDotOnScale2);
    if (!forward) {
      h = -h;
    }
    for (int j = 0; j < y0.length; j++) {
      y0[j] += h * yDot0[j];
    }
    computeDerivatives(t0 + h, y1, yDot1);
    
    double yDDotOnScale = 0.0D;
    for (int j = 0; j < y0.length; j++)
    {
      double ratio = (yDot1[j] - yDot0[j]) / scale[j];
      yDDotOnScale += ratio * ratio;
    }
    yDDotOnScale = Math.sqrt(yDDotOnScale) / h;
    
    double maxInv2 = Math.max(Math.sqrt(yDotOnScale2), yDDotOnScale);
    double h1 = maxInv2 < 1.0E-15D ? Math.max(1.0E-6D, 0.001D * Math.abs(h)) : Math.pow(0.01D / maxInv2, 1.0D / order);
    
    h = Math.min(100.0D * Math.abs(h), h1);
    h = Math.max(h, 1.0E-12D * Math.abs(t0));
    if (h < getMinStep()) {
      h = getMinStep();
    }
    if (h > getMaxStep()) {
      h = getMaxStep();
    }
    if (!forward) {
      h = -h;
    }
    return h;
  }
  
  protected double filterStep(double h, boolean forward, boolean acceptSmall)
    throws IntegratorException
  {
    double filteredH = h;
    if (Math.abs(h) < minStep) {
      if (acceptSmall) {
        filteredH = forward ? minStep : -minStep;
      } else {
        throw new IntegratorException("minimal step size ({0,number,0.00E00}) reached, integration needs {1,number,0.00E00}", new Object[] { Double.valueOf(minStep), Double.valueOf(Math.abs(h)) });
      }
    }
    if (filteredH > maxStep) {
      filteredH = maxStep;
    } else if (filteredH < -maxStep) {
      filteredH = -maxStep;
    }
    return filteredH;
  }
  
  public abstract double integrate(FirstOrderDifferentialEquations paramFirstOrderDifferentialEquations, double paramDouble1, double[] paramArrayOfDouble1, double paramDouble2, double[] paramArrayOfDouble2)
    throws DerivativeException, IntegratorException;
  
  public double getCurrentStepStart()
  {
    return stepStart;
  }
  
  protected void resetInternalState()
  {
    stepStart = NaN.0D;
    stepSize = Math.sqrt(minStep * maxStep);
  }
  
  public double getMinStep()
  {
    return minStep;
  }
  
  public double getMaxStep()
  {
    return maxStep;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.AdaptiveStepsizeIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
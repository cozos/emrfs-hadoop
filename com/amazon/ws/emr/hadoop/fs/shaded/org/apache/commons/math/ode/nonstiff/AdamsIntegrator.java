package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.Array2DRowRealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.IntegratorException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.MultistepIntegrator;

public abstract class AdamsIntegrator
  extends MultistepIntegrator
{
  private final AdamsNordsieckTransformer transformer;
  
  public AdamsIntegrator(String name, int nSteps, int order, double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance)
    throws IllegalArgumentException
  {
    super(name, nSteps, order, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
    
    transformer = AdamsNordsieckTransformer.getInstance(nSteps);
  }
  
  public AdamsIntegrator(String name, int nSteps, int order, double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance)
    throws IllegalArgumentException
  {
    super(name, nSteps, order, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
    
    transformer = AdamsNordsieckTransformer.getInstance(nSteps);
  }
  
  public abstract double integrate(FirstOrderDifferentialEquations paramFirstOrderDifferentialEquations, double paramDouble1, double[] paramArrayOfDouble1, double paramDouble2, double[] paramArrayOfDouble2)
    throws DerivativeException, IntegratorException;
  
  protected Array2DRowRealMatrix initializeHighOrderDerivatives(double[] first, double[][] multistep)
  {
    return transformer.initializeHighOrderDerivatives(first, multistep);
  }
  
  public Array2DRowRealMatrix updateHighOrderDerivativesPhase1(Array2DRowRealMatrix highOrder)
  {
    return transformer.updateHighOrderDerivativesPhase1(highOrder);
  }
  
  public void updateHighOrderDerivativesPhase2(double[] start, double[] end, Array2DRowRealMatrix highOrder)
  {
    transformer.updateHighOrderDerivativesPhase2(start, end, highOrder);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.AdamsIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
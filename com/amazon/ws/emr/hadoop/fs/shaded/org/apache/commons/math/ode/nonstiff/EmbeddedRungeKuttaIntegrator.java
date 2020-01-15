package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.IntegratorException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.CombinedEventsManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.AbstractStepInterpolator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.DummyStepInterpolator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepHandler;

public abstract class EmbeddedRungeKuttaIntegrator
  extends AdaptiveStepsizeIntegrator
{
  private final boolean fsal;
  private final double[] c;
  private final double[][] a;
  private final double[] b;
  private final RungeKuttaStepInterpolator prototype;
  private final double exp;
  private double safety;
  private double minReduction;
  private double maxGrowth;
  
  protected EmbeddedRungeKuttaIntegrator(String name, boolean fsal, double[] c, double[][] a, double[] b, RungeKuttaStepInterpolator prototype, double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance)
  {
    super(name, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
    
    this.fsal = fsal;
    this.c = c;
    this.a = a;
    this.b = b;
    this.prototype = prototype;
    
    exp = (-1.0D / getOrder());
    
    setSafety(0.9D);
    setMinReduction(0.2D);
    setMaxGrowth(10.0D);
  }
  
  protected EmbeddedRungeKuttaIntegrator(String name, boolean fsal, double[] c, double[][] a, double[] b, RungeKuttaStepInterpolator prototype, double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance)
  {
    super(name, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
    
    this.fsal = fsal;
    this.c = c;
    this.a = a;
    this.b = b;
    this.prototype = prototype;
    
    exp = (-1.0D / getOrder());
    
    setSafety(0.9D);
    setMinReduction(0.2D);
    setMaxGrowth(10.0D);
  }
  
  public abstract int getOrder();
  
  public double getSafety()
  {
    return safety;
  }
  
  public void setSafety(double safety)
  {
    this.safety = safety;
  }
  
  public double integrate(FirstOrderDifferentialEquations equations, double t0, double[] y0, double t, double[] y)
    throws DerivativeException, IntegratorException
  {
    sanityChecks(equations, t0, y0, t, y);
    setEquations(equations);
    resetEvaluations();
    boolean forward = t > t0;
    
    int stages = c.length + 1;
    if (y != y0) {
      System.arraycopy(y0, 0, y, 0, y0.length);
    }
    double[][] yDotK = new double[stages][y0.length];
    double[] yTmp = new double[y0.length];
    AbstractStepInterpolator interpolator;
    AbstractStepInterpolator interpolator;
    if ((requiresDenseOutput()) || (!eventsHandlersManager.isEmpty()))
    {
      RungeKuttaStepInterpolator rki = (RungeKuttaStepInterpolator)prototype.copy();
      rki.reinitialize(this, yTmp, yDotK, forward);
      interpolator = rki;
    }
    else
    {
      interpolator = new DummyStepInterpolator(yTmp, yDotK[(stages - 1)], forward);
    }
    interpolator.storeTime(t0);
    
    stepStart = t0;
    double hNew = 0.0D;
    boolean firstTime = true;
    for (StepHandler handler : stepHandlers) {
      handler.reset();
    }
    CombinedEventsManager manager = addEndTimeChecker(t0, t, eventsHandlersManager);
    boolean lastStep = false;
    while (!lastStep)
    {
      interpolator.shift();
      
      double error = 0.0D;
      for (boolean loop = true; loop;)
      {
        if ((firstTime) || (!fsal)) {
          computeDerivatives(stepStart, y, yDotK[0]);
        }
        if (firstTime)
        {
          double[] scale = new double[y0.length];
          if (vecAbsoluteTolerance == null) {
            for (int i = 0; i < scale.length; i++) {
              scale[i] = (scalAbsoluteTolerance + scalRelativeTolerance * Math.abs(y[i]));
            }
          } else {
            for (int i = 0; i < scale.length; i++) {
              scale[i] = (vecAbsoluteTolerance[i] + vecRelativeTolerance[i] * Math.abs(y[i]));
            }
          }
          hNew = initializeStep(equations, forward, getOrder(), scale, stepStart, y, yDotK[0], yTmp, yDotK[1]);
          
          firstTime = false;
        }
        stepSize = hNew;
        for (int k = 1; k < stages; k++)
        {
          for (int j = 0; j < y0.length; j++)
          {
            double sum = a[(k - 1)][0] * yDotK[0][j];
            for (int l = 1; l < k; l++) {
              sum += a[(k - 1)][l] * yDotK[l][j];
            }
            y[j] += stepSize * sum;
          }
          computeDerivatives(stepStart + c[(k - 1)] * stepSize, yTmp, yDotK[k]);
        }
        for (int j = 0; j < y0.length; j++)
        {
          double sum = b[0] * yDotK[0][j];
          for (int l = 1; l < stages; l++) {
            sum += b[l] * yDotK[l][j];
          }
          y[j] += stepSize * sum;
        }
        error = estimateError(yDotK, y, yTmp, stepSize);
        if (error <= 1.0D)
        {
          interpolator.storeTime(stepStart + stepSize);
          if (manager.evaluateStep(interpolator))
          {
            double dt = manager.getEventTime() - stepStart;
            if (Math.abs(dt) <= Math.ulp(stepStart))
            {
              interpolator.storeTime(stepStart);
              System.arraycopy(y, 0, yTmp, 0, y0.length);
              hNew = 0.0D;
              stepSize = 0.0D;
              loop = false;
            }
            else
            {
              hNew = dt;
            }
          }
          else
          {
            loop = false;
          }
        }
        else
        {
          double factor = Math.min(maxGrowth, Math.max(minReduction, safety * Math.pow(error, exp)));
          
          hNew = filterStep(stepSize * factor, forward, false);
        }
      }
      double nextStep = stepStart + stepSize;
      System.arraycopy(yTmp, 0, y, 0, y0.length);
      manager.stepAccepted(nextStep, y);
      lastStep = manager.stop();
      
      interpolator.storeTime(nextStep);
      for (StepHandler handler : stepHandlers) {
        handler.handleStep(interpolator, lastStep);
      }
      stepStart = nextStep;
      if (fsal) {
        System.arraycopy(yDotK[(stages - 1)], 0, yDotK[0], 0, y0.length);
      }
      if ((manager.reset(stepStart, y)) && (!lastStep)) {
        computeDerivatives(stepStart, y, yDotK[0]);
      }
      if (!lastStep)
      {
        stepSize = filterStep(stepSize, forward, true);
        
        double factor = Math.min(maxGrowth, Math.max(minReduction, safety * Math.pow(error, exp)));
        
        double scaledH = stepSize * factor;
        double nextT = stepStart + scaledH;
        boolean nextIsLast = nextT >= t;
        hNew = filterStep(scaledH, forward, nextIsLast);
      }
    }
    double stopTime = stepStart;
    resetInternalState();
    return stopTime;
  }
  
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
  
  protected abstract double estimateError(double[][] paramArrayOfDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double paramDouble);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.EmbeddedRungeKuttaIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
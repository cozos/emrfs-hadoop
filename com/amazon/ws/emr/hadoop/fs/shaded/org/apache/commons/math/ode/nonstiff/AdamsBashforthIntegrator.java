package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.Array2DRowRealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.IntegratorException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.CombinedEventsManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.NordsieckStepInterpolator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepHandler;

public class AdamsBashforthIntegrator
  extends AdamsIntegrator
{
  public AdamsBashforthIntegrator(int nSteps, double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance)
    throws IllegalArgumentException
  {
    super("Adams-Bashforth", nSteps, nSteps, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
  }
  
  public AdamsBashforthIntegrator(int nSteps, double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance)
    throws IllegalArgumentException
  {
    super("Adams-Bashforth", nSteps, nSteps, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
  }
  
  public double integrate(FirstOrderDifferentialEquations equations, double t0, double[] y0, double t, double[] y)
    throws DerivativeException, IntegratorException
  {
    int n = y0.length;
    sanityChecks(equations, t0, y0, t, y);
    setEquations(equations);
    resetEvaluations();
    boolean forward = t > t0;
    if (y != y0) {
      System.arraycopy(y0, 0, y, 0, n);
    }
    double[] yDot = new double[n];
    double[] yTmp = new double[y0.length];
    
    NordsieckStepInterpolator interpolator = new NordsieckStepInterpolator();
    interpolator.reinitialize(y, forward);
    NordsieckStepInterpolator interpolatorTmp = new NordsieckStepInterpolator();
    interpolatorTmp.reinitialize(yTmp, forward);
    for (StepHandler handler : stepHandlers) {
      handler.reset();
    }
    CombinedEventsManager manager = addEndTimeChecker(t0, t, eventsHandlersManager);
    
    start(t0, y, t);
    interpolator.reinitialize(stepStart, stepSize, scaled, nordsieck);
    interpolator.storeTime(stepStart);
    int lastRow = nordsieck.getRowDimension() - 1;
    
    double hNew = stepSize;
    interpolator.rescale(hNew);
    
    boolean lastStep = false;
    while (!lastStep)
    {
      interpolator.shift();
      
      double error = 0.0D;
      for (boolean loop = true; loop;)
      {
        stepSize = hNew;
        
        error = 0.0D;
        for (int i = 0; i < y0.length; i++)
        {
          double yScale = Math.abs(y[i]);
          double tol = vecAbsoluteTolerance == null ? scalAbsoluteTolerance + scalRelativeTolerance * yScale : vecAbsoluteTolerance[i] + vecRelativeTolerance[i] * yScale;
          
          double ratio = nordsieck.getEntry(lastRow, i) / tol;
          error += ratio * ratio;
        }
        error = Math.sqrt(error / y0.length);
        if (error <= 1.0D)
        {
          double stepEnd = stepStart + stepSize;
          interpolator.setInterpolatedTime(stepEnd);
          System.arraycopy(interpolator.getInterpolatedState(), 0, yTmp, 0, y0.length);
          
          computeDerivatives(stepEnd, yTmp, yDot);
          
          double[] predictedScaled = new double[y0.length];
          for (int j = 0; j < y0.length; j++) {
            predictedScaled[j] = (stepSize * yDot[j]);
          }
          Array2DRowRealMatrix nordsieckTmp = updateHighOrderDerivativesPhase1(nordsieck);
          updateHighOrderDerivativesPhase2(scaled, predictedScaled, nordsieckTmp);
          
          interpolatorTmp.reinitialize(stepEnd, stepSize, predictedScaled, nordsieckTmp);
          interpolatorTmp.storeTime(stepStart);
          interpolatorTmp.shift();
          interpolatorTmp.storeTime(stepEnd);
          if (manager.evaluateStep(interpolatorTmp))
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
              interpolator.rescale(hNew);
            }
          }
          else
          {
            scaled = predictedScaled;
            nordsieck = nordsieckTmp;
            interpolator.reinitialize(stepEnd, stepSize, scaled, nordsieck);
            loop = false;
          }
        }
        else
        {
          double factor = computeStepGrowShrinkFactor(error);
          hNew = filterStep(stepSize * factor, forward, false);
          interpolator.rescale(hNew);
        }
      }
      double nextStep = stepStart + stepSize;
      System.arraycopy(yTmp, 0, y, 0, n);
      interpolator.storeTime(nextStep);
      manager.stepAccepted(nextStep, y);
      lastStep = manager.stop();
      for (StepHandler handler : stepHandlers)
      {
        interpolator.setInterpolatedTime(nextStep);
        handler.handleStep(interpolator, lastStep);
      }
      stepStart = nextStep;
      if ((!lastStep) && (manager.reset(stepStart, y)))
      {
        start(stepStart, y, t);
        interpolator.reinitialize(stepStart, stepSize, scaled, nordsieck);
      }
      if (!lastStep)
      {
        stepSize = filterStep(stepSize, forward, true);
        
        double factor = computeStepGrowShrinkFactor(error);
        double scaledH = stepSize * factor;
        double nextT = stepStart + scaledH;
        boolean nextIsLast = nextT >= t;
        hNew = filterStep(scaledH, forward, nextIsLast);
        interpolator.rescale(hNew);
      }
    }
    double stopTime = stepStart;
    stepStart = NaN.0D;
    stepSize = NaN.0D;
    return stopTime;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
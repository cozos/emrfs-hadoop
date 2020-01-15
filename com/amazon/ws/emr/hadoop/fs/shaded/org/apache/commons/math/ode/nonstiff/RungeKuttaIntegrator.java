package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.AbstractIntegrator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.IntegratorException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.CombinedEventsManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.AbstractStepInterpolator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.DummyStepInterpolator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepHandler;

public abstract class RungeKuttaIntegrator
  extends AbstractIntegrator
{
  private final double[] c;
  private final double[][] a;
  private final double[] b;
  private final RungeKuttaStepInterpolator prototype;
  private final double step;
  
  protected RungeKuttaIntegrator(String name, double[] c, double[][] a, double[] b, RungeKuttaStepInterpolator prototype, double step)
  {
    super(name);
    this.c = c;
    this.a = a;
    this.b = b;
    this.prototype = prototype;
    this.step = Math.abs(step);
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
    double[][] yDotK = new double[stages][];
    for (int i = 0; i < stages; i++) {
      yDotK[i] = new double[y0.length];
    }
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
    stepSize = (forward ? step : -step);
    for (StepHandler handler : stepHandlers) {
      handler.reset();
    }
    CombinedEventsManager manager = addEndTimeChecker(t0, t, eventsHandlersManager);
    boolean lastStep = false;
    while (!lastStep)
    {
      interpolator.shift();
      for (boolean loop = true; loop;)
      {
        computeDerivatives(stepStart, y, yDotK[0]);
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
        interpolator.storeTime(stepStart + stepSize);
        if (manager.evaluateStep(interpolator))
        {
          double dt = manager.getEventTime() - stepStart;
          if (Math.abs(dt) <= Math.ulp(stepStart))
          {
            interpolator.storeTime(stepStart);
            System.arraycopy(y, 0, yTmp, 0, y0.length);
            stepSize = 0.0D;
            loop = false;
          }
          else
          {
            stepSize = dt;
          }
        }
        else
        {
          loop = false;
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
      if ((manager.reset(stepStart, y)) && (!lastStep)) {
        computeDerivatives(stepStart, y, yDotK[0]);
      }
      stepSize = (forward ? step : -step);
    }
    double stopTime = stepStart;
    stepStart = NaN.0D;
    stepSize = NaN.0D;
    return stopTime;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.RungeKuttaIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
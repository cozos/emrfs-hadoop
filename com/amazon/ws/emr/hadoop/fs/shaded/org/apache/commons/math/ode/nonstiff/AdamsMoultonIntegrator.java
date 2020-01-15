package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.Array2DRowRealMatrix;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.MatrixVisitorException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrixPreservingVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.IntegratorException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.events.CombinedEventsManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.NordsieckStepInterpolator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.sampling.StepHandler;
import java.util.Arrays;

public class AdamsMoultonIntegrator
  extends AdamsIntegrator
{
  public AdamsMoultonIntegrator(int nSteps, double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance)
    throws IllegalArgumentException
  {
    super("Adams-Moulton", nSteps, nSteps + 1, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
  }
  
  public AdamsMoultonIntegrator(int nSteps, double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance)
    throws IllegalArgumentException
  {
    super("Adams-Moulton", nSteps, nSteps + 1, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
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
    double[] yDot = new double[y0.length];
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
        
        error = nordsieckTmp.walkInOptimizedOrder(new Corrector(y, predictedScaled, yTmp));
        if (error <= 1.0D)
        {
          computeDerivatives(stepEnd, yTmp, yDot);
          
          double[] correctedScaled = new double[y0.length];
          for (int j = 0; j < y0.length; j++) {
            correctedScaled[j] = (stepSize * yDot[j]);
          }
          updateHighOrderDerivativesPhase2(predictedScaled, correctedScaled, nordsieckTmp);
          
          interpolatorTmp.reinitialize(stepEnd, stepSize, correctedScaled, nordsieckTmp);
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
            scaled = correctedScaled;
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
  
  private class Corrector
    implements RealMatrixPreservingVisitor
  {
    private final double[] previous;
    private final double[] scaled;
    private final double[] before;
    private final double[] after;
    
    public Corrector(double[] previous, double[] scaled, double[] state)
    {
      this.previous = previous;
      this.scaled = scaled;
      after = state;
      before = ((double[])state.clone());
    }
    
    public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn)
    {
      Arrays.fill(after, 0.0D);
    }
    
    public void visit(int row, int column, double value)
      throws MatrixVisitorException
    {
      if ((row & 0x1) == 0) {
        after[column] -= value;
      } else {
        after[column] += value;
      }
    }
    
    public double end()
    {
      double error = 0.0D;
      for (int i = 0; i < after.length; i++)
      {
        after[i] += previous[i] + scaled[i];
        double yScale = Math.max(Math.abs(previous[i]), Math.abs(after[i]));
        double tol = vecAbsoluteTolerance == null ? scalAbsoluteTolerance + scalRelativeTolerance * yScale : vecAbsoluteTolerance[i] + vecRelativeTolerance[i] * yScale;
        
        double ratio = (after[i] - before[i]) / tol;
        error += ratio * ratio;
      }
      return Math.sqrt(error / after.length);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.AdamsMoultonIntegrator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
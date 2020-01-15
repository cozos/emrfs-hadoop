package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.OptimizationException;

public class HarmonicFitter
{
  private final CurveFitter fitter;
  private double[] parameters;
  
  public HarmonicFitter(DifferentiableMultivariateVectorialOptimizer optimizer)
  {
    fitter = new CurveFitter(optimizer);
    parameters = null;
  }
  
  public HarmonicFitter(DifferentiableMultivariateVectorialOptimizer optimizer, double[] initialGuess)
  {
    fitter = new CurveFitter(optimizer);
    parameters = ((double[])initialGuess.clone());
  }
  
  public void addObservedPoint(double weight, double x, double y)
  {
    fitter.addObservedPoint(weight, x, y);
  }
  
  public HarmonicFunction fit()
    throws OptimizationException
  {
    try
    {
      if (parameters == null)
      {
        WeightedObservedPoint[] observations = fitter.getObservations();
        if (observations.length < 4) {
          throw new OptimizationException("sample contains {0} observed points, at least {1} are required", new Object[] { Integer.valueOf(observations.length), Integer.valueOf(4) });
        }
        HarmonicCoefficientsGuesser guesser = new HarmonicCoefficientsGuesser(observations);
        guesser.guess();
        parameters = new double[] { guesser.getGuessedAmplitude(), guesser.getGuessedPulsation(), guesser.getGuessedPhase() };
      }
      double[] fitted = fitter.fit(new ParametricHarmonicFunction(null), parameters);
      return new HarmonicFunction(fitted[0], fitted[1], fitted[2]);
    }
    catch (FunctionEvaluationException fee)
    {
      throw MathRuntimeException.createInternalError(fee);
    }
  }
  
  private static class ParametricHarmonicFunction
    implements ParametricRealFunction
  {
    public double value(double x, double[] parameters)
    {
      double a = parameters[0];
      double omega = parameters[1];
      double phi = parameters[2];
      return a * Math.cos(omega * x + phi);
    }
    
    public double[] gradient(double x, double[] parameters)
    {
      double a = parameters[0];
      double omega = parameters[1];
      double phi = parameters[2];
      double alpha = omega * x + phi;
      double cosAlpha = Math.cos(alpha);
      double sinAlpha = Math.sin(alpha);
      return new double[] { cosAlpha, -a * x * sinAlpha, -a * sinAlpha };
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting.HarmonicFitter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
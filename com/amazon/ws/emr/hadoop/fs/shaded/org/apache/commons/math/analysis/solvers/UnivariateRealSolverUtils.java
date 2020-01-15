package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public class UnivariateRealSolverUtils
{
  private static final String NULL_FUNCTION_MESSAGE = "function is null";
  
  public static double solve(UnivariateRealFunction f, double x0, double x1)
    throws ConvergenceException, FunctionEvaluationException
  {
    setup(f);
    return LazyHolder.FACTORY.newDefaultSolver().solve(f, x0, x1);
  }
  
  public static double solve(UnivariateRealFunction f, double x0, double x1, double absoluteAccuracy)
    throws ConvergenceException, FunctionEvaluationException
  {
    setup(f);
    UnivariateRealSolver solver = LazyHolder.FACTORY.newDefaultSolver();
    solver.setAbsoluteAccuracy(absoluteAccuracy);
    return solver.solve(f, x0, x1);
  }
  
  public static double[] bracket(UnivariateRealFunction function, double initial, double lowerBound, double upperBound)
    throws ConvergenceException, FunctionEvaluationException
  {
    return bracket(function, initial, lowerBound, upperBound, Integer.MAX_VALUE);
  }
  
  public static double[] bracket(UnivariateRealFunction function, double initial, double lowerBound, double upperBound, int maximumIterations)
    throws ConvergenceException, FunctionEvaluationException
  {
    if (function == null) {
      throw MathRuntimeException.createIllegalArgumentException("function is null", new Object[0]);
    }
    if (maximumIterations <= 0) {
      throw MathRuntimeException.createIllegalArgumentException("bad value for maximum iterations number: {0}", new Object[] { Integer.valueOf(maximumIterations) });
    }
    if ((initial < lowerBound) || (initial > upperBound) || (lowerBound >= upperBound)) {
      throw MathRuntimeException.createIllegalArgumentException("invalid bracketing parameters:  lower bound={0},  initial={1}, upper bound={2}", new Object[] { Double.valueOf(lowerBound), Double.valueOf(initial), Double.valueOf(upperBound) });
    }
    double a = initial;
    double b = initial;
    
    int numIterations = 0;
    double fa;
    double fb;
    do
    {
      a = Math.max(a - 1.0D, lowerBound);
      b = Math.min(b + 1.0D, upperBound);
      fa = function.value(a);
      
      fb = function.value(b);
      numIterations++;
    } while ((fa * fb > 0.0D) && (numIterations < maximumIterations) && ((a > lowerBound) || (b < upperBound)));
    if (fa * fb > 0.0D) {
      throw new ConvergenceException("number of iterations={0}, maximum iterations={1}, initial={2}, lower bound={3}, upper bound={4}, final a value={5}, final b value={6}, f(a)={7}, f(b)={8}", new Object[] { Integer.valueOf(numIterations), Integer.valueOf(maximumIterations), Double.valueOf(initial), Double.valueOf(lowerBound), Double.valueOf(upperBound), Double.valueOf(a), Double.valueOf(b), Double.valueOf(fa), Double.valueOf(fb) });
    }
    return new double[] { a, b };
  }
  
  public static double midpoint(double a, double b)
  {
    return (a + b) * 0.5D;
  }
  
  private static void setup(UnivariateRealFunction f)
  {
    if (f == null) {
      throw MathRuntimeException.createIllegalArgumentException("function is null", new Object[0]);
    }
  }
  
  private static class LazyHolder
  {
    private static final UnivariateRealSolverFactory FACTORY = ;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.univariate;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.GoalType;

public class BrentOptimizer
  extends AbstractUnivariateRealOptimizer
{
  private static final double GOLDEN_SECTION = 0.5D * (3.0D - Math.sqrt(5.0D));
  
  public BrentOptimizer()
  {
    super(100, 1.0E-10D);
  }
  
  public double optimize(UnivariateRealFunction f, GoalType goalType, double min, double max, double startValue)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    return optimize(f, goalType, min, max);
  }
  
  public double optimize(UnivariateRealFunction f, GoalType goalType, double min, double max)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    clearResult();
    return localMin(f, goalType, min, max, relativeAccuracy, absoluteAccuracy);
  }
  
  private double localMin(UnivariateRealFunction f, GoalType goalType, double a, double b, double eps, double t)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    double x = a + GOLDEN_SECTION * (b - a);
    double v = x;
    double w = x;
    double e = 0.0D;
    double fx = computeObjectiveValue(f, x);
    if (goalType == GoalType.MAXIMIZE) {
      fx = -fx;
    }
    double fv = fx;
    double fw = fx;
    
    int count = 0;
    while (count < maximalIterationCount)
    {
      double m = 0.5D * (a + b);
      double tol = eps * Math.abs(x) + t;
      double t2 = 2.0D * tol;
      if (Math.abs(x - m) > t2 - 0.5D * (b - a))
      {
        double p = 0.0D;
        double q = 0.0D;
        double r = 0.0D;
        double d = 0.0D;
        double u = 0.0D;
        if (Math.abs(e) > tol)
        {
          r = (x - w) * (fx - fv);
          q = (x - v) * (fx - fw);
          p = (x - v) * q - (x - w) * r;
          q = 2.0D * (q - r);
          if (q > 0.0D) {
            p = -p;
          } else {
            q = -q;
          }
          r = e;
          e = d;
        }
        if ((Math.abs(p) < Math.abs(0.5D * q * r)) && (p < q * (a - x)) && (p < q * (b - x)))
        {
          d = p / q;
          u = x + d;
          if ((u - a < t2) || (b - u < t2)) {
            d = x < m ? tol : -tol;
          }
        }
        else
        {
          e = (x < m ? b : a) - x;
          d = GOLDEN_SECTION * e;
        }
        u = x + (d > 0.0D ? tol : Math.abs(d) > tol ? d : -tol);
        double fu = computeObjectiveValue(f, u);
        if (goalType == GoalType.MAXIMIZE) {
          fu = -fu;
        }
        if (fu <= fx)
        {
          if (u < x) {
            b = x;
          } else {
            a = x;
          }
          v = w;
          fv = fw;
          w = x;
          fw = fx;
          x = u;
          fx = fu;
        }
        else
        {
          if (u < x) {
            a = u;
          } else {
            b = u;
          }
          if ((fu <= fw) || (w == x))
          {
            v = w;
            fv = fw;
            w = u;
            fw = fu;
          }
          else if ((fu <= fv) || (v == x) || (v == w))
          {
            v = u;
            fv = fu;
          }
        }
      }
      else
      {
        setResult(x, goalType == GoalType.MAXIMIZE ? -fx : fx, count);
        return x;
      }
      count++;
    }
    throw new MaxIterationsExceededException(maximalIterationCount);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.univariate.BrentOptimizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.Serializable;

public abstract class AbstractIntegerDistribution
  extends AbstractDistribution
  implements IntegerDistribution, Serializable
{
  private static final String WRONG_ORDER_ENDPOINTS_MESSAGE = "lower endpoint ({0}) must be less than or equal to upper endpoint ({1})";
  private static final String OUT_OF_RANGE_POINT = "{0} out of [{1}, {2}] range";
  private static final long serialVersionUID = -1146319659338487221L;
  
  public double cumulativeProbability(double x)
    throws MathException
  {
    return cumulativeProbability((int)Math.floor(x));
  }
  
  public double cumulativeProbability(double x0, double x1)
    throws MathException
  {
    if (x0 > x1) {
      throw MathRuntimeException.createIllegalArgumentException("lower endpoint ({0}) must be less than or equal to upper endpoint ({1})", new Object[] { Double.valueOf(x0), Double.valueOf(x1) });
    }
    if (Math.floor(x0) < x0) {
      return cumulativeProbability((int)Math.floor(x0) + 1, (int)Math.floor(x1));
    }
    return cumulativeProbability((int)Math.floor(x0), (int)Math.floor(x1));
  }
  
  public abstract double cumulativeProbability(int paramInt)
    throws MathException;
  
  public double probability(double x)
  {
    double fl = Math.floor(x);
    if (fl == x) {
      return probability((int)x);
    }
    return 0.0D;
  }
  
  public double cumulativeProbability(int x0, int x1)
    throws MathException
  {
    if (x0 > x1) {
      throw MathRuntimeException.createIllegalArgumentException("lower endpoint ({0}) must be less than or equal to upper endpoint ({1})", new Object[] { Integer.valueOf(x0), Integer.valueOf(x1) });
    }
    return cumulativeProbability(x1) - cumulativeProbability(x0 - 1);
  }
  
  public int inverseCumulativeProbability(double p)
    throws MathException
  {
    if ((p < 0.0D) || (p > 1.0D)) {
      throw MathRuntimeException.createIllegalArgumentException("{0} out of [{1}, {2}] range", new Object[] { Double.valueOf(p), Double.valueOf(0.0D), Double.valueOf(1.0D) });
    }
    int x0 = getDomainLowerBound(p);
    int x1 = getDomainUpperBound(p);
    while (x0 < x1)
    {
      int xm = x0 + (x1 - x0) / 2;
      double pm = checkedCumulativeProbability(xm);
      if (pm > p)
      {
        if (xm == x1) {
          x1--;
        } else {
          x1 = xm;
        }
      }
      else if (xm == x0) {
        x0++;
      } else {
        x0 = xm;
      }
    }
    double pm = checkedCumulativeProbability(x0);
    while (pm > p)
    {
      x0--;
      pm = checkedCumulativeProbability(x0);
    }
    return x0;
  }
  
  private double checkedCumulativeProbability(int argument)
    throws FunctionEvaluationException
  {
    double result = NaN.0D;
    try
    {
      result = cumulativeProbability(argument);
    }
    catch (MathException ex)
    {
      throw new FunctionEvaluationException(ex, argument, ex.getPattern(), ex.getArguments());
    }
    if (Double.isNaN(result)) {
      throw new FunctionEvaluationException(argument, "Discrete cumulative probability function returned NaN for argument {0}", new Object[] { Integer.valueOf(argument) });
    }
    return result;
  }
  
  protected abstract int getDomainLowerBound(double paramDouble);
  
  protected abstract int getDomainUpperBound(double paramDouble);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.AbstractIntegerDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
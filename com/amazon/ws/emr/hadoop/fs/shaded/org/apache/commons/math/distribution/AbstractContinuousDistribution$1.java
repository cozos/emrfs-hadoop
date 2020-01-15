package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

class AbstractContinuousDistribution$1
  implements UnivariateRealFunction
{
  AbstractContinuousDistribution$1(AbstractContinuousDistribution paramAbstractContinuousDistribution, double paramDouble) {}
  
  public double value(double x)
    throws FunctionEvaluationException
  {
    double ret = NaN.0D;
    try
    {
      ret = this$0.cumulativeProbability(x) - val$p;
    }
    catch (MathException ex)
    {
      throw new FunctionEvaluationException(ex, x, ex.getPattern(), ex.getArguments());
    }
    if (Double.isNaN(ret)) {
      throw new FunctionEvaluationException(x, "Cumulative probability function returned NaN for argument {0} p = {1}", new Object[] { Double.valueOf(x), Double.valueOf(val$p) });
    }
    return ret;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.AbstractContinuousDistribution.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
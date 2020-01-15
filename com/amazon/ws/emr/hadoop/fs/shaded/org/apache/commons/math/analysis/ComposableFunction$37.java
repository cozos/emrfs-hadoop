package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

class ComposableFunction$37
  implements MultivariateRealFunction
{
  ComposableFunction$37(ComposableFunction paramComposableFunction, double paramDouble, BivariateRealFunction paramBivariateRealFunction) {}
  
  public double value(double[] point)
    throws FunctionEvaluationException, IllegalArgumentException
  {
    double result = val$initialValue;
    for (double entry : point) {
      result = val$combiner.value(result, this$0.value(entry));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.ComposableFunction.37
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
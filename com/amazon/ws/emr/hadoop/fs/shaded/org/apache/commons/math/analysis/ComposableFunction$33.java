package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

class ComposableFunction$33
  extends ComposableFunction
{
  ComposableFunction$33(ComposableFunction paramComposableFunction, UnivariateRealFunction paramUnivariateRealFunction) {}
  
  public double value(double x)
    throws FunctionEvaluationException
  {
    return this$0.value(x) - val$f.value(x);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.ComposableFunction.33
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
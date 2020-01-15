package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

class ComposableFunction$30
  extends ComposableFunction
{
  ComposableFunction$30(ComposableFunction paramComposableFunction, BivariateRealFunction paramBivariateRealFunction, UnivariateRealFunction paramUnivariateRealFunction) {}
  
  public double value(double x)
    throws FunctionEvaluationException
  {
    return val$combiner.value(this$0.value(x), val$f.value(x));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.ComposableFunction.30
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
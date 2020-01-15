package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

public abstract interface UnivariateVectorialFunction
{
  public abstract double[] value(double paramDouble)
    throws FunctionEvaluationException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateVectorialFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

public abstract interface MultivariateVectorialFunction
{
  public abstract double[] value(double[] paramArrayOfDouble)
    throws FunctionEvaluationException, IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.MultivariateVectorialFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
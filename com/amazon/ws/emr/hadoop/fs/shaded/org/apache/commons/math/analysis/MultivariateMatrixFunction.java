package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

public abstract interface MultivariateMatrixFunction
{
  public abstract double[][] value(double[] paramArrayOfDouble)
    throws FunctionEvaluationException, IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.MultivariateMatrixFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
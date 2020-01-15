package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

public abstract interface ParametricRealFunction
{
  public abstract double value(double paramDouble, double[] paramArrayOfDouble)
    throws FunctionEvaluationException;
  
  public abstract double[] gradient(double paramDouble, double[] paramArrayOfDouble)
    throws FunctionEvaluationException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.fitting.ParametricRealFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
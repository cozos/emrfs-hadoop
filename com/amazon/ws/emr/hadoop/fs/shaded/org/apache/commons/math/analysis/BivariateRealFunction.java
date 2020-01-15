package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

public abstract interface BivariateRealFunction
{
  public abstract double value(double paramDouble1, double paramDouble2)
    throws FunctionEvaluationException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.BivariateRealFunction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
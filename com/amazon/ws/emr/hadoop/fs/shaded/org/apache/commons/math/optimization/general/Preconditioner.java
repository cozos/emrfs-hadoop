package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;

public abstract interface Preconditioner
{
  public abstract double[] precondition(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
    throws FunctionEvaluationException, IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.general.Preconditioner
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
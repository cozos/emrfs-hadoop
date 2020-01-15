package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public abstract interface RealTransformer
{
  public abstract double[] transform(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract double[] transform(UnivariateRealFunction paramUnivariateRealFunction, double paramDouble1, double paramDouble2, int paramInt)
    throws FunctionEvaluationException, IllegalArgumentException;
  
  public abstract double[] inversetransform(double[] paramArrayOfDouble)
    throws IllegalArgumentException;
  
  public abstract double[] inversetransform(UnivariateRealFunction paramUnivariateRealFunction, double paramDouble1, double paramDouble2, int paramInt)
    throws FunctionEvaluationException, IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.transform.RealTransformer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public abstract interface Distribution
{
  public abstract double cumulativeProbability(double paramDouble)
    throws MathException;
  
  public abstract double cumulativeProbability(double paramDouble1, double paramDouble2)
    throws MathException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.Distribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.inference;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public abstract interface ChiSquareTest
{
  public abstract double chiSquare(double[] paramArrayOfDouble, long[] paramArrayOfLong)
    throws IllegalArgumentException;
  
  public abstract double chiSquareTest(double[] paramArrayOfDouble, long[] paramArrayOfLong)
    throws IllegalArgumentException, MathException;
  
  public abstract boolean chiSquareTest(double[] paramArrayOfDouble, long[] paramArrayOfLong, double paramDouble)
    throws IllegalArgumentException, MathException;
  
  public abstract double chiSquare(long[][] paramArrayOfLong)
    throws IllegalArgumentException;
  
  public abstract double chiSquareTest(long[][] paramArrayOfLong)
    throws IllegalArgumentException, MathException;
  
  public abstract boolean chiSquareTest(long[][] paramArrayOfLong, double paramDouble)
    throws IllegalArgumentException, MathException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.inference.ChiSquareTest
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
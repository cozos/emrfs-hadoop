package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.inference;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public abstract interface UnknownDistributionChiSquareTest
  extends ChiSquareTest
{
  public abstract double chiSquareDataSetsComparison(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    throws IllegalArgumentException;
  
  public abstract double chiSquareTestDataSetsComparison(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    throws IllegalArgumentException, MathException;
  
  public abstract boolean chiSquareTestDataSetsComparison(long[] paramArrayOfLong1, long[] paramArrayOfLong2, double paramDouble)
    throws IllegalArgumentException, MathException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.inference.UnknownDistributionChiSquareTest
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
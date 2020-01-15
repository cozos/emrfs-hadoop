package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.inference;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import java.util.Collection;

public abstract interface OneWayAnova
{
  public abstract double anovaFValue(Collection<double[]> paramCollection)
    throws IllegalArgumentException, MathException;
  
  public abstract double anovaPValue(Collection<double[]> paramCollection)
    throws IllegalArgumentException, MathException;
  
  public abstract boolean anovaTest(Collection<double[]> paramCollection, double paramDouble)
    throws IllegalArgumentException, MathException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.inference.OneWayAnova
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
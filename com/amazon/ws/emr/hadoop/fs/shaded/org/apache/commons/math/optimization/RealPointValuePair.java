package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization;

import java.io.Serializable;

public class RealPointValuePair
  implements Serializable
{
  private static final long serialVersionUID = 1003888396256744753L;
  private final double[] point;
  private final double value;
  
  public RealPointValuePair(double[] point, double value)
  {
    this.point = ((double[])point.clone());
    this.value = value;
  }
  
  public RealPointValuePair(double[] point, double value, boolean copyArray)
  {
    this.point = (copyArray ? (double[])point.clone() : point);
    this.value = value;
  }
  
  public double[] getPoint()
  {
    return (double[])point.clone();
  }
  
  public double[] getPointRef()
  {
    return point;
  }
  
  public double getValue()
  {
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.RealPointValuePair
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
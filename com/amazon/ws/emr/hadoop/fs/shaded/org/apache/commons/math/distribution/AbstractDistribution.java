package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.Serializable;

public abstract class AbstractDistribution
  implements Distribution, Serializable
{
  private static final long serialVersionUID = -38038050983108802L;
  
  public double cumulativeProbability(double x0, double x1)
    throws MathException
  {
    if (x0 > x1) {
      throw MathRuntimeException.createIllegalArgumentException("lower endpoint ({0}) must be less than or equal to upper endpoint ({1})", new Object[] { Double.valueOf(x0), Double.valueOf(x1) });
    }
    return cumulativeProbability(x1) - cumulativeProbability(x0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.AbstractDistribution
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
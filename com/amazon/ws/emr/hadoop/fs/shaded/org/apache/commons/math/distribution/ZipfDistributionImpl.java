package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.Serializable;

public class ZipfDistributionImpl
  extends AbstractIntegerDistribution
  implements ZipfDistribution, Serializable
{
  private static final long serialVersionUID = -140627372283420404L;
  private int numberOfElements;
  private double exponent;
  
  public ZipfDistributionImpl(int numberOfElements, double exponent)
    throws IllegalArgumentException
  {
    setNumberOfElementsInternal(numberOfElements);
    setExponentInternal(exponent);
  }
  
  public int getNumberOfElements()
  {
    return numberOfElements;
  }
  
  @Deprecated
  public void setNumberOfElements(int n)
  {
    setNumberOfElementsInternal(n);
  }
  
  private void setNumberOfElementsInternal(int n)
    throws IllegalArgumentException
  {
    if (n <= 0) {
      throw MathRuntimeException.createIllegalArgumentException("invalid number of elements {0} (must be positive)", new Object[] { Integer.valueOf(n) });
    }
    numberOfElements = n;
  }
  
  public double getExponent()
  {
    return exponent;
  }
  
  @Deprecated
  public void setExponent(double s)
  {
    setExponentInternal(s);
  }
  
  private void setExponentInternal(double s)
    throws IllegalArgumentException
  {
    if (s <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("invalid exponent {0} (must be positive)", new Object[] { Double.valueOf(s) });
    }
    exponent = s;
  }
  
  public double probability(int x)
  {
    if ((x <= 0) || (x > numberOfElements)) {
      return 0.0D;
    }
    return 1.0D / Math.pow(x, exponent) / generalizedHarmonic(numberOfElements, exponent);
  }
  
  public double cumulativeProbability(int x)
  {
    if (x <= 0) {
      return 0.0D;
    }
    if (x >= numberOfElements) {
      return 1.0D;
    }
    return generalizedHarmonic(x, exponent) / generalizedHarmonic(numberOfElements, exponent);
  }
  
  protected int getDomainLowerBound(double p)
  {
    return 0;
  }
  
  protected int getDomainUpperBound(double p)
  {
    return numberOfElements;
  }
  
  private double generalizedHarmonic(int n, double m)
  {
    double value = 0.0D;
    for (int k = n; k > 0; k--) {
      value += 1.0D / Math.pow(k, m);
    }
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.ZipfDistributionImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
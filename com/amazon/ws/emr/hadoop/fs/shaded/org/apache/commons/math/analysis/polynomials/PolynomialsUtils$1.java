package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction.BigFraction;

final class PolynomialsUtils$1
  implements PolynomialsUtils.RecurrenceCoefficientsGenerator
{
  private final BigFraction[] coeffs = { BigFraction.ZERO, BigFraction.TWO, BigFraction.ONE };
  
  public BigFraction[] generate(int k)
  {
    return coeffs;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials.PolynomialsUtils.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
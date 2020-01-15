package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction.BigFraction;

final class PolynomialsUtils$2
  implements PolynomialsUtils.RecurrenceCoefficientsGenerator
{
  public BigFraction[] generate(int k)
  {
    return new BigFraction[] { BigFraction.ZERO, BigFraction.TWO, new BigFraction(2 * k) };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials.PolynomialsUtils.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
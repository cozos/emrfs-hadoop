package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction.BigFraction;

final class PolynomialsUtils$3
  implements PolynomialsUtils.RecurrenceCoefficientsGenerator
{
  public BigFraction[] generate(int k)
  {
    int kP1 = k + 1;
    return new BigFraction[] { new BigFraction(2 * k + 1, kP1), new BigFraction(-1, kP1), new BigFraction(k, kP1) };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials.PolynomialsUtils.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
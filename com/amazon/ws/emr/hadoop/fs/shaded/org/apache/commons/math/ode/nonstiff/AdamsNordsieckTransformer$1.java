package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction.BigFraction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.DefaultFieldMatrixChangingVisitor;

class AdamsNordsieckTransformer$1
  extends DefaultFieldMatrixChangingVisitor<BigFraction>
{
  AdamsNordsieckTransformer$1(AdamsNordsieckTransformer paramAdamsNordsieckTransformer, BigFraction x0)
  {
    super(x0);
  }
  
  public BigFraction visit(int row, int column, BigFraction value)
  {
    return (column & 0x1) == 1 ? value : value.negate();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.nonstiff.AdamsNordsieckTransformer.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
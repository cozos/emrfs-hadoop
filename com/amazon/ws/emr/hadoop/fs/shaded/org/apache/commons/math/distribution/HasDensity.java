package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

/**
 * @deprecated
 */
public abstract interface HasDensity<P>
{
  public abstract double density(P paramP)
    throws MathException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.HasDensity
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
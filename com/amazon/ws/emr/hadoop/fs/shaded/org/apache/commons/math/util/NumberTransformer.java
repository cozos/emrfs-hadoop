package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public abstract interface NumberTransformer
{
  public abstract double transform(Object paramObject)
    throws MathException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.NumberTransformer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
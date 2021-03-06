package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;

public class FractionConversionException
  extends ConvergenceException
{
  private static final long serialVersionUID = -4661812640132576263L;
  
  public FractionConversionException(double value, int maxIterations)
  {
    super("Unable to convert {0} to fraction after {1} iterations", new Object[] { Double.valueOf(value), Integer.valueOf(maxIterations) });
  }
  
  public FractionConversionException(double value, long p, long q)
  {
    super("Overflow trying to convert {0} to fraction ({1}/{2})", new Object[] { Double.valueOf(value), Long.valueOf(p), Long.valueOf(q) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction.FractionConversionException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
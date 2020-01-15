package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

public class DuplicateSampleAbscissaException
  extends MathException
{
  private static final long serialVersionUID = -2271007547170169872L;
  
  public DuplicateSampleAbscissaException(double abscissa, int i1, int i2)
  {
    super("Abscissa {0} is duplicated at both indices {1} and {2}", new Object[] { Double.valueOf(abscissa), Integer.valueOf(i1), Integer.valueOf(i2) });
  }
  
  public double getDuplicateAbscissa()
  {
    return ((Double)getArguments()[0]).doubleValue();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.DuplicateSampleAbscissaException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
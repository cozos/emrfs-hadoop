package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public class DerivativeException
  extends MathException
{
  private static final long serialVersionUID = 5666710788967425123L;
  
  public DerivativeException(String specifier, Object... parts)
  {
    super(specifier, parts);
  }
  
  public DerivativeException(Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.DerivativeException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
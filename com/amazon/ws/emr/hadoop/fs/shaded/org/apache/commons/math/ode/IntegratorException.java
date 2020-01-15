package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public class IntegratorException
  extends MathException
{
  private static final long serialVersionUID = -1607588949778036796L;
  
  public IntegratorException(String specifier, Object... parts)
  {
    super(specifier, parts);
  }
  
  public IntegratorException(Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ode.IntegratorException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
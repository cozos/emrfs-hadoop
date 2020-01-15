package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;

public class OptimizationException
  extends ConvergenceException
{
  private static final long serialVersionUID = -357696069587075016L;
  
  public OptimizationException(String specifier, Object... parts)
  {
    super(specifier, parts);
  }
  
  public OptimizationException(Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.OptimizationException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
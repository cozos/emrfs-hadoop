package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

public class MaxIterationsExceededException
  extends ConvergenceException
{
  private static final long serialVersionUID = -7821226672760574694L;
  private final int maxIterations;
  
  public MaxIterationsExceededException(int maxIterations)
  {
    super("Maximal number of iterations ({0}) exceeded", new Object[] { Integer.valueOf(maxIterations) });
    this.maxIterations = maxIterations;
  }
  
  public MaxIterationsExceededException(int maxIterations, String pattern, Object... arguments)
  {
    super(pattern, arguments);
    this.maxIterations = maxIterations;
  }
  
  public int getMaxIterations()
  {
    return maxIterations;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
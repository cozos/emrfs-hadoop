package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

public class ConvergenceException
  extends MathException
{
  private static final long serialVersionUID = 4883703247677159141L;
  
  public ConvergenceException()
  {
    super("Convergence failed", new Object[0]);
  }
  
  public ConvergenceException(String pattern, Object... arguments)
  {
    super(pattern, arguments);
  }
  
  public ConvergenceException(Throwable cause)
  {
    super(cause);
  }
  
  public ConvergenceException(Throwable cause, String pattern, Object... arguments)
  {
    super(cause, pattern, arguments);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

public class MaxEvaluationsExceededException
  extends ConvergenceException
{
  private static final long serialVersionUID = -5921271447220129118L;
  private final int maxEvaluations;
  
  public MaxEvaluationsExceededException(int maxEvaluations)
  {
    super("Maximal number of evaluations ({0}) exceeded", new Object[] { Integer.valueOf(maxEvaluations) });
    this.maxEvaluations = maxEvaluations;
  }
  
  public MaxEvaluationsExceededException(int maxEvaluations, String pattern, Object... arguments)
  {
    super(pattern, arguments);
    this.maxEvaluations = maxEvaluations;
  }
  
  public int getMaxEvaluations()
  {
    return maxEvaluations;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxEvaluationsExceededException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
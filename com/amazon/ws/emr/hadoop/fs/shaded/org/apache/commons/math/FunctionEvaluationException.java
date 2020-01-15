package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.ArrayRealVector;

public class FunctionEvaluationException
  extends MathException
{
  private static final long serialVersionUID = -4305020489115478365L;
  private static final String FAILED_EVALUATION_MESSAGE = "evaluation failed for argument = {0}";
  private double[] argument;
  
  public FunctionEvaluationException(double argument)
  {
    super("evaluation failed for argument = {0}", new Object[] { Double.valueOf(argument) });
    this.argument = new double[] { argument };
  }
  
  public FunctionEvaluationException(double[] argument)
  {
    super("evaluation failed for argument = {0}", new Object[] { new ArrayRealVector(argument) });
    this.argument = ((double[])argument.clone());
  }
  
  public FunctionEvaluationException(double argument, String pattern, Object... arguments)
  {
    super(pattern, arguments);
    this.argument = new double[] { argument };
  }
  
  public FunctionEvaluationException(double[] argument, String pattern, Object... arguments)
  {
    super(pattern, arguments);
    this.argument = ((double[])argument.clone());
  }
  
  public FunctionEvaluationException(Throwable cause, double argument)
  {
    super(cause);
    this.argument = new double[] { argument };
  }
  
  public FunctionEvaluationException(Throwable cause, double[] argument)
  {
    super(cause);
    this.argument = ((double[])argument.clone());
  }
  
  public FunctionEvaluationException(Throwable cause, double argument, String pattern, Object... arguments)
  {
    super(cause, pattern, arguments);
    this.argument = new double[] { argument };
  }
  
  public FunctionEvaluationException(Throwable cause, double[] argument, String pattern, Object... arguments)
  {
    super(cause, pattern, arguments);
    this.argument = ((double[])argument.clone());
  }
  
  public double[] getArgument()
  {
    return (double[])argument.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
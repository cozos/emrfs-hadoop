package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

public class ArgumentOutsideDomainException
  extends FunctionEvaluationException
{
  private static final long serialVersionUID = -4965972841162580234L;
  
  public ArgumentOutsideDomainException(double argument, double lower, double upper)
  {
    super(argument, "Argument {0} outside domain [{1} ; {2}]", new Object[] { Double.valueOf(argument), Double.valueOf(lower), Double.valueOf(upper) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ArgumentOutsideDomainException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
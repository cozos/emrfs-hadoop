package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public class NotPositiveDefiniteMatrixException
  extends MathException
{
  private static final long serialVersionUID = 4122929125438624648L;
  
  public NotPositiveDefiniteMatrixException()
  {
    super("not positive definite matrix", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.NotPositiveDefiniteMatrixException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
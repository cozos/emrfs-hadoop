package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public class NotSymmetricMatrixException
  extends MathException
{
  private static final long serialVersionUID = -7012803946709786097L;
  
  public NotSymmetricMatrixException()
  {
    super("not symmetric matrix", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.NotSymmetricMatrixException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
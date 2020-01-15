package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;

public class MatrixVisitorException
  extends MathRuntimeException
{
  private static final long serialVersionUID = 3814333035048617048L;
  
  public MatrixVisitorException(String pattern, Object[] arguments)
  {
    super(pattern, arguments);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.MatrixVisitorException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
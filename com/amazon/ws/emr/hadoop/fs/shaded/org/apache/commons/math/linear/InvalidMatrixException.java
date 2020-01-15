package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;

public class InvalidMatrixException
  extends MathRuntimeException
{
  private static final long serialVersionUID = 1135533765052675495L;
  
  public InvalidMatrixException(String pattern, Object... arguments)
  {
    super(pattern, arguments);
  }
  
  public InvalidMatrixException(Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.InvalidMatrixException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
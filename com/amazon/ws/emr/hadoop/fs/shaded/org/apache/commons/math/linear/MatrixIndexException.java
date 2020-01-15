package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;

public class MatrixIndexException
  extends MathRuntimeException
{
  private static final long serialVersionUID = -2382324504109300625L;
  
  public MatrixIndexException(String pattern, Object... arguments)
  {
    super(pattern, arguments);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.MatrixIndexException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.geometry;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public class NotARotationMatrixException
  extends MathException
{
  private static final long serialVersionUID = 5647178478658937642L;
  
  public NotARotationMatrixException(String specifier, Object... parts)
  {
    super(specifier, parts);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.geometry.NotARotationMatrixException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
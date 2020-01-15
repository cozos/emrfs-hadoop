package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import java.io.Serializable;

public class DefaultTransformer
  implements NumberTransformer, Serializable
{
  private static final long serialVersionUID = 4019938025047800455L;
  
  public double transform(Object o)
    throws MathException
  {
    if (o == null) {
      throw new MathException("Conversion Exception in Transformation, Object is null", new Object[0]);
    }
    if ((o instanceof Number)) {
      return ((Number)o).doubleValue();
    }
    try
    {
      return Double.valueOf(o.toString()).doubleValue();
    }
    catch (NumberFormatException e)
    {
      throw new MathException(e, "Conversion Exception in Transformation: {0}", new Object[] { e.getMessage() });
    }
  }
  
  public boolean equals(Object other)
  {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    return other instanceof DefaultTransformer;
  }
  
  public int hashCode()
  {
    return 401993047;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.DefaultTransformer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
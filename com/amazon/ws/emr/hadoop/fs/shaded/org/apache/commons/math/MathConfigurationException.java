package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math;

import java.io.Serializable;

public class MathConfigurationException
  extends MathException
  implements Serializable
{
  private static final long serialVersionUID = 5261476508226103366L;
  
  public MathConfigurationException() {}
  
  public MathConfigurationException(String pattern, Object... arguments)
  {
    super(pattern, arguments);
  }
  
  public MathConfigurationException(Throwable cause)
  {
    super(cause);
  }
  
  public MathConfigurationException(Throwable cause, String pattern, Object... arguments)
  {
    super(cause, pattern, arguments);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathConfigurationException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
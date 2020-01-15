package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.estimation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

@Deprecated
public class EstimationException
  extends MathException
{
  private static final long serialVersionUID = -573038581493881337L;
  
  public EstimationException(String specifier, Object... parts)
  {
    super(specifier, parts);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.estimation.EstimationException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
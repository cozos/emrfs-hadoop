package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.geometry;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;

public class CardanEulerSingularityException
  extends MathException
{
  private static final long serialVersionUID = -1360952845582206770L;
  
  public CardanEulerSingularityException(boolean isCardan)
  {
    super(isCardan ? "Cardan angles singularity" : "Euler angles singularity", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.geometry.CardanEulerSingularityException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
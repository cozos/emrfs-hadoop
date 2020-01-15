package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.moment;

public enum SemiVariance$Direction
{
  UPSIDE(true),  DOWNSIDE(false);
  
  private boolean direction;
  
  private SemiVariance$Direction(boolean b)
  {
    direction = b;
  }
  
  boolean getDirection()
  {
    return direction;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.descriptive.moment.SemiVariance.Direction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
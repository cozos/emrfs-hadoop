package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.inference;

class OneWayAnovaImpl$AnovaStats
{
  private int dfbg;
  private int dfwg;
  private double F;
  
  private OneWayAnovaImpl$AnovaStats(int dfbg, int dfwg, double F)
  {
    this.dfbg = dfbg;
    this.dfwg = dfwg;
    this.F = F;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.inference.OneWayAnovaImpl.AnovaStats
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
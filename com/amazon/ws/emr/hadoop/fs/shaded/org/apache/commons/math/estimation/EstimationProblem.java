package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.estimation;

@Deprecated
public abstract interface EstimationProblem
{
  public abstract WeightedMeasurement[] getMeasurements();
  
  public abstract EstimatedParameter[] getUnboundParameters();
  
  public abstract EstimatedParameter[] getAllParameters();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.estimation.EstimationProblem
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */
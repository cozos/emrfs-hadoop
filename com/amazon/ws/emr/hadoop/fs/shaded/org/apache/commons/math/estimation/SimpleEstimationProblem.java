package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.estimation;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class SimpleEstimationProblem
  implements EstimationProblem
{
  private final List<EstimatedParameter> parameters;
  private final List<WeightedMeasurement> measurements;
  
  public SimpleEstimationProblem()
  {
    parameters = new ArrayList();
    measurements = new ArrayList();
  }
  
  public EstimatedParameter[] getAllParameters()
  {
    return (EstimatedParameter[])parameters.toArray(new EstimatedParameter[parameters.size()]);
  }
  
  public EstimatedParameter[] getUnboundParameters()
  {
    List<EstimatedParameter> unbound = new ArrayList(parameters.size());
    for (EstimatedParameter p : parameters) {
      if (!p.isBound()) {
        unbound.add(p);
      }
    }
    return (EstimatedParameter[])unbound.toArray(new EstimatedParameter[unbound.size()]);
  }
  
  public WeightedMeasurement[] getMeasurements()
  {
    return (WeightedMeasurement[])measurements.toArray(new WeightedMeasurement[measurements.size()]);
  }
  
  protected void addParameter(EstimatedParameter p)
  {
    parameters.add(p);
  }
  
  protected void addMeasurement(WeightedMeasurement m)
  {
    measurements.add(m);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.estimation.SimpleEstimationProblem
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */